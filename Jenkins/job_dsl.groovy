folder('Projects') {
	description('Folder for project')
}


pipelineJob('Example Job') {
	parameters {
		stringParam('NAME_REPO', null, 'eg: httpstest/test.git')
		stringParam('NAME_BRANCH', null, 'eg: */master')
		stringParam('RELEASE', null, 'eg: V.0.9')
	}
	definition {
		cps {
			script('''
				pipeline {
					agent any
					stages {
						stage('Checkout') {
							steps {
								script {
									checkout([$class: 'GitSCM', branches: [[name: '${NAME_BRANCH}']], gitTool: 'Default', userRemoteConfigs: [[url: '${NAME_REPO}']]])
								}
							}
						}
						stage('Test') {
							steps {
								sh 'echo "Hello-World"'
							}
						}
						stage('Download') {
							steps {
								sh 'apt-get install zip'
								sh 'zip RELEASE_${RELEASE}.zip ./* '
							}
						}
					}
					post {
						always {
							archiveArtifacts artifacts: '**/*.zip', onlyIfSuccessful: true
							junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
						}
					}
				}
			'''.stripIndent())
			sandbox()
		}
	}
}