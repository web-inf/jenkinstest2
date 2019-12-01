node {
  withEnv(["PATH=${tool params.JENKINS_MVN_TOOL_NAME}/bin:${env.PATH}","PACKAGE_DIR=${ARTIFACT_DIR}/${MODULE_NAME}","PACKAGE_TGZ_NAME=${MODULE_NAME}-${MODULE_VERSION}.tar.gz"]){

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
      sh '''
        mkdir -p ${PACKAGE_DIR}
        cp -R target/job-front.tar.gz ${PACKAGE_DIR}
      '''

      // 进入artifact目录，重命名压缩包
      dir("${ARTIFACT_DIR}") {
        sh '''
          echo ${PACKAGE_TGZ_NAME}
          mv ${MODULE_NAME}/job-front.tar.gz  ${PACKAGE_TGZ_NAME}
        '''
        // 让Jenkins可以下载到这个压缩包
        archiveArtifacts "${PACKAGE_TGZ_NAME}"
      }
    }

  }
}
