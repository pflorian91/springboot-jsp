#! /bin/sh

#_JVM_PROTOCOL='-Dsun.net.http.allowRestrictedHeaders=true'
#_JVM_DEBUG='-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n'
_JVM_SECURITY=''
_JVM_PROXY_SETTINGS=''
_JVM_SYSTEM_SETTINGS='--add-opens java.base/jdk.internal.loader=ALL-UNNAMED'

# Create ${APP_NAME} inside dumps volume
mkdir -p /dumps/data/${APP_NAME}

# Time Stamp
export TS=`date +%d%m%Y_%H%M%S`
export JVM_HEAP_SETTINGS='-XX:+UseContainerSupport -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/dumps/data/${APP_NAME}/heap_dump_${POD_NAME}_${TS}.hprof -XX:+ExitOnOutOfMemoryError'

# If necessary, set $JAVA_OPTS at "docker run" or in Kubernetes pod template
/usr/bin/java $_JVM_SECURITY $_JVM_PROXY_SETTINGS $_JVM_SYSTEM_SETTINGS ${JVM_HEAP_SETTINGS} $JAVA_OPTS $*