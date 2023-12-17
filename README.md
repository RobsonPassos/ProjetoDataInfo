Este Projeto funciona da seguinte forma:

### **você envia um arquivo.xml ele recupera todas os dados de cada tag e insere no banco de dados o valor de cada tag é um registro!**
### **Na sequência é redirecionado para uma tela JSP onde é listado todos os registro inseridos, essa lista é recuperada do banco de dados através de JPA.**

## No projeto está incluido as seguintes tecnologias:
## Servlet, XML, EJB, JBOSS, JSP, SQL.

para executar a aplicação eu utilizei o Jboss versão Wildfly 27.0.1-Final.
Deve ser feito a configuração do datasource no diretório dele exemplo:

C:\Users\robso\Dev\serverapp\wildfly-27.0.1.Final\standalone\configuration

### 1.Abra o arquivo standalone.xml e configure o datasource assim:

<subsystem xmlns="urn:jboss:domain:datasources:7.0">
            <datasources>
                <datasource jta="true" jndi-name="java:/jboss/datasources/basetesterob" pool-name="basetesterobPool" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5432/basetesterob</connection-url>
                    <driver>postgresql</driver>
                    <security>
                        <user-name>postgres</user-name>
                        <password>12345</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="postgresql" module="org.postgresql">
                        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
            </datasources>
        </subsystem>

### 2. No diretório: C:\Users\robso\Dev\serverapp\wildfly-27.0.1.Final\modules\system\layers\base\org

## Crie uma pasta chamada "postgresql" depois dentro dela crie uma outra pasta chamada "main", dentro dela adicione o .jar referente a versão do seu banco de dados, no meu caso eu add o postgresql-42.3.6.jar

## Neste mesmo diretório crie um arquivo xml chamado "module.xml" e adicione a seguintes configurações.
<module xmlns="urn:jboss:module:1.9" name="org.postgresql">
	<resources>
		<resource-root path="postgresql-42.3.6.jar"/>
	</resources>
	<dependencies>
		<module name="javax.api"/>
		<module name="javax.transaction.api"/>
	</dependencies>
</module>

Pronto está configurado o seu datasource!

# Um exemplo de XML que eu testei a aplicação:
<?xml version="1.0" encoding="UTF-8"?>
<dados>
    <valor1>Conteúdo da tag valor1</valor1>
    <valor2>Conteúdo da tag valor2</valor2>
    <valor3>Conteúdo da tag valor3</valor3>
</dados>

Qualquer dúvida me contactar WhatsApp 47992860205


