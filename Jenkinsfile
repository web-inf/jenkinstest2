node {
  withEnv(["PATH=${tool params.JENKINS_MVN_TOOL_NAME}/bin:${env.PATH}","PACKAGE_DIR=${ARTIFACT_DIR}/${MODULE_NAME}","PACKAGE_TGZ_NAME=${MODULE_NAME}-${MODULE_VERSION}.jar"]){

    stage("Init") {
      // 清理工作空间
      cleanWs()

      // 拉取最新代码
      checkout scm
    }

    stage('Build') {
      sh 'mvn clean compile'
    }

    stage('Test') {
      echo "test"
    }

    stage('Package') {

      sh 'mvn package -Dmaven.test.skip=true'

      // 将安装包放到(PACKAGE_DIR)artifact/job-front/目录下

    }
      //
    stage('run') {
      sh '''
         cd  "$(pwd)"
         java -jar  ./target/${PACKAGE_TGZ_NAME}
      '''
    }
  }
}
