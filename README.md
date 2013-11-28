Manual do Desenvolvedor

Instalação do Java 7

Escolhido o Java 7, pois é a versão mais recente. É necessário fazer o download no link http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html e a instalação do JDK.

Instalação do Eclipse

A IDE escolhida para utilização foi o Eclipse, pois oferece ferramentas robustas para o desenvolvimento de aplicações web desenvolvidas em Java. Faça o download da versão mais recente pra JavaEE Developers no  link http://www.eclipse.org/downloads/. É necessário ter uma versão do Java instalada para a execução dessa IDE. Se houver problemas para a inicialização, configurar a jvm conforme o link http://wiki.eclipse.org/Eclipse.ini#Specifying_the_JVM .

Download do plugin do GWT e GAE para o Eclipse

No Eclipse, na versão do Kepler, clicar em Help > Install New Software … Para outras versões do eclipse, consultar https://developers.google.com/eclipse/docs/getting_started#installing . Na caixa de diálogo que aparece, digitar no text box “Work with” a seguinte url: https://dl.google.com/eclipse/plugin/4.3 
e digitar a tecla “Enter”. A caixa de diálogo ficará como a seguir:

Selecione o checkbox “Google Plugin for Eclipse(required)” e clique em “next”. Na próxima página de diálogo, deve aparecer o detalhe de “Google Plugin for Eclipse 4.3”, conforme a próxima imagem:


Clique em “Next”. Leia os termos de licença e selecione “I accept the terms of the license agreements.” e clique em “Finish”. Ao aparecer o aviso, clique em “OK”. Será solicitado que o eclipse seja reiniciado; clique em “Yes”.

Github

Para controle de versão, foi escolhida a ferramenta Github, por ser gratuita e robusta.

Criar uma conta no Github

Para fazer o download do projeto, é necessário possuir uma conta cadastrada no github.

EGit

Baixar o Plugin do Github para o Eclipse (EGit). Clicar em Help > Eclipse Marketplace > pesquisar por egit > Instalar Egit - Git Team Provider

Download do projeto

Na visualixação do Package/Project Explorer, clicar com o botão direito no conteúdo da tela. Selecionar Import > Git > Projects from Git > URI . Informar a URI: https://github.com/CyJeliel/classeEncanto.git . Informar nome de usuário e senha do github. Selecionar apenas "master" e escolher um diretório para fazer o download. Selecionar "Import Existing Projects" e selecionar apenas o chackbox de classeEncanto.

Criar domínio no GAE

Acessar https://appengine.google.com/‎ . Se já possuir uma conta do Google, basta acessar com seus dados. Caso contrário, será necessário criar uma conta. Ao acessar com seus dados, será redirecionado para a seguinte página:


Clique em “Create Application”. Será redirecionado para a página:



	Preencha seus dados, a forma como deseja que o Google o contate e clique em “Send verification code” (Atenção: o telefone deve ser no formato XX XXXXX-XXXX). Após receber o código de confirmação, informe-o e clique em “Verify”, como na tela a seguir:


	Você será redirecionado para a tela de criação da aplicação:

	Preencha os dados, leia os termos de licença, marque o check box para concordar com os termos de licença e clique em “Create Application”. Se houver algum erro no preenchimento, corrija-os conforme as mensagens de feedback. Após criar a aplicação, aparecerá a seguinte tela:


Fazer deploy da aplicação no GAE
//TODO: CINDY

Acessar o Banco de Dados do GAE
//TODO: CINDY


