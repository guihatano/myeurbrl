# myeurbrl

My project to see 1 Euro in Brazilian Real currency (EURBRL)

Its a Java EE project with JSF and WildFly server

This version is just a prototype

### Why this project?

Because I can't see every 10 minutes every day how much is the EUR in BRL, sometimes I forget to see or I'm busy to see. And I need buy EUR.

### The idea

Notify me when the 1 EUR is under X BRL.

### How?

Using Javamail and Jsoup (Javamail to send email and Jsoup to parse HTML from other site).

### Why Jsoup?

I need to get the currency quote from a source, so I get the informations from a site parsing the HTML. If there are others solutions, tell me.

### Why it is a web project?

It could be a desktop project, but I preferred to do web.


## Configure Javamail in WildFly

Using command line:

cd WILDFLY_HOME/bin
./jboss-cli.sh --connect --user=admin --password=password

I'm using gmail (don't forget to allow "less secure apps" https://www.google.com/settings/security/lesssecureapps) 

/socket-binding-group=standard-sockets/remote-destination-outbound-socket-binding=mail-smtp:add(host=smtp.gmail.com, port=465)

/subsystem=mail/mail-session=myeurbrlMail:add(jndi-name=java:/mail/myeurbrlMail)

/subsystem=mail/mail-session=myeurbrlMail/server=smtp:add(outbound-socket-binding-ref=mail-smtp, ssl=true, username=your_email@gmail.com, password=your_password)
