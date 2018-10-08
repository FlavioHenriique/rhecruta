FROM payara/server-full:5.183

ENV APPNAME rhecruta
ENV DOMAIN domain1

#Executando o domain1 para permitir autodeploy
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}