1.Definição

Padrão Observer: padrão de desenvolvimento de
software que define uma relação de 1 para muitos
entre objectos

Assim, qdo um objecto muda de estado todos os
outros que se encontram dependentes deles são
notificados e actualizados automaticamente

Padrão é constituído por 2 "peças" base:
    subject - representa o serviço, controla
    o estado dos observers
    observers - representa o assinante, estão
    dependentes do subject para actualizar-se

--------
Listener é um objecto que reage a um evento.

Os listeners são normalmente interfaces que
um objecto tem que implementar para poder
receber um certo evento.
--------

Problema:

É necessário fazer várias representações de
um mesmo conjunto de dados.
Este conjunto de dados consiste numa estrutura
que contém 3 atributos:
    valorA, valorB e valorC


Representação dos dados será feita
    1. numa tabela, que simplesmente exibe os número,
    2. gráficos de barras, onde os valores são exibidos
    em barras e
    3. em percentagam, relativo à soma total dos valores.

A representação deve ser feita de modo que qualquer
alteração no conjunto de dados partilhados provoque
alterações em todas as formas de representação, garantindo
que uma visão nunca tenha dados invalidados.

Também queremos que as representações sejam redesenhadas
somente quando necessário. Ou seja, sempre que um valor
é alterado.

Uma primeira solução poderia ser manter uma lista com as
possíveis representações e ficar verificando por mudanças
no conjunto de dados, assim que fosse feita uma mudança, as
visualizações seriam avisadas.

O problema é que precisamos sempre verificar se houve ou
não mudança no conjunto de dados, dessa forma o processamento
seria muito caro, ou então a actualização seria demorada.

Vamos ver então como o padrão Observer pode ajudar

// ----------- Observer ----------- //

Intenção:

“Definir uma dependência um para muitos entre objectos, de
maneira que quando um objecto muda de estado todos os seus
dependentes são notificados e actualizados automaticamente.”

O padrão Observer parece ser uma boa solução para o problema,
pois ele define uma dependência um para muitos, que será
necessária para fazer a relação entre um conjunto de dados e
várias representações, além de permitir que, quando um
objecto mude de estado, todos os dependentes sejam notificados.


--------- Subject ---------

Criar uma classe que mantém o conjunto de dados e uma lista de
dependentes deste conjunto, assim a cada mudança no conjunto de
dados todos os dependentes são notificados.

Vejamos então o código desta classe por partes:


Inicialmente definimos a lista de observadores  - Observer é uma
interface comum aos observadores e será definida a seguir -
e o conjunto de dados a ser compartilhado. Também definimos os
métodos para

    1. adicionar e
    2. remover observadores,

assim cada novo observador poderá facilmente acompanhar as mudanças.

Dentro da mesma classe, vamos definir as mudanças no estado, ou seja,
o conjunto de dados.

Sempre que for feita uma mudança no conjunto de dados, através do
método “setState()” é chamado o método que vai notificar todos os
observadores, executando um update() para informar que o conjunto mudou.

--------- Observer ---------

Vamos ver então como seria um observador.

Vamos definir então a interface comum a todos os observadores,
utilizada para manter a lista de observadores na classe que controla o
conjunto de dados.

--------- TabelaObserver ---------

Definida a interface vamos então construir o observador que mostra os
dados numa tabela.

Este observador simplesmente exibe o valor dos dados. Assim, quando o
método update() for chamado ele irá redesenhar a tabela de dados.
Para o exemplo apenas vamos exibir algumas
informações no standard output.

--------- PercentagemObserver ---------

Outros observers podem definir outras maneiras de mostrar o conjunto de
dados, por exemplo exibir os valores em percentagem.

Para este observer é feito inicialmente o cálculo da soma dos valores e
depois é calculado cada valor em relação a este total, exibindo o
resultado com duas casas decimais

--------- BarraObserver ---------



Na nomenclatura do padrão Observer temos os duas classes principais:

    Subject e Observer.

1. Subject: mantém os dados partilhados e a lista de observadores que partilham
o dado.
2. Observer é o que faz utilização dos dados partilhados e deve ser actualizado
a cada modificação.

Como vimos no nosso exemplo o padrão Observer oferece uma excelente maneira de
partilhar um recurso, utilizando uma técnica parecida com o broadcast, onde
todos os observers referenciados num subject são notificados sobre mudanças.

Ao realizar uma mudança é necessário ter cuidado, pois não se sabe exactamente os
efeitos desta mudança nos seus observers ou o custo das actualizações nos observers.
Caso as mudanças sejam muito complexas ou muito custosas pode ser interessante
implementar uma estrutura intermediária para gerir os subjects e observers e
suas mudanças.

Outro motivo para se utilizar uma estrutura intermediária entre subject e observer
é quando existem muitos subjects e muitos observers interligados.
Uma estrutura para mapear subjects e observers pode ser mais eficiente que uma
lista de observers em cada subject.

Essa estrutura intermediária muitas vezes pode ser uma instância do padrão Mediator.
Também é interessante que esta classe intermediária seja uma instância do padrão
Singleton, pois é interessante que apenas um objecto centralize o controle de
subjects e observers.


Importante: também que no exemplo acima cometemos um pequeno “erro”, pois não
definimos a classe Subject como uma interface, isso dificultaria bastante
alterações nesta classe. Geralmente a interface de Subject define apenas os
métodos de adição e remoção de Observers e o método de notificação.

As subclasses de Subject vão definir como será a inserção e remoção de observers, e
como estes observers serão notificados. Além disso ela deve apresentar uma
maneira dos observers acederem os dados partilhados, definindo assim os métodos
de “getState()” e “setState()”


source: https://brizeno.wordpress.com/2011/10/17/mao-na-massa-currentlecture.observer1/

recomendo: GUI Architectures Martin Fawler https://martinfowler.com/eaaDev/uiArchs.html

--------------------------------


O Observer é um padrão de projeto de software que define uma dependência um-para-muitos entre
objectos de modo que quando um objecto muda o estado, todos seus dependentes são notificados e
actualizados automaticamente. Permite que objectos interessados sejam avisados da mudança de
estado ou outros eventos ocorrendo num outro objecto.

O padrão Observer é também chamado de Publisher-Subscriber, Event Generator e Dependents.

1. Descrição de um problema

Suponha que temos um programa que representa vários gráficos de uma pesquisa científica e utiliza
vários dados para representar esse gráfico, e se um dado for atualizado o programa deve atualizar
os gráficos. Para esse problema, uma solução poderia ser manter uma lista com as possíveis repre-
sentações e ficar verificando por mudanças nos conjuntos de dados, assim que fosse feita mudança,
as representações que está na lista seriam avisadas.

Essa solução não é a melhor pois precisamos sempre verificar se houve essas mudanças no conjunto,
e dessa forma o processamento seria muito caro, ou então a atualização seria demorada. Portanto,
o padrão Observer resolve esse problema.

2. Motivação
Um objecto que possua agregações deve permitir que seus elementos sejam acessados sem que a sua
estrutura interna seja exposta. De uma maneira geral pode-se desejar que estes elementos sejam
percorridos em várias ordens.

Como garantir que objectos que dependem de outro objecto percebam as mudanças naquele objecto?

Os observadores (currentlecture.observer1) devem conhecer o objecto de interesse.
O objecto de interesse (subject) deve notificar os observadores quando for atualizado.
Os objectos devem interligar-se entre si de forma a que não se conheçam em tempo de compilação de
forma a criar o acoplamento e desfazê-lo a qualquer momento em tempo de execução. Solucionar isso
fornece uma implementação muito flexível de acoplamento de abstrações.

3. Aplicabilidade
O padrão Observer pode ser usado quando uma abstração tem dois aspectos, um dependente do outro.
Encapsular tais aspectos em objectos separados permite que variem e sejam reusados separadamente.
Quando uma mudança a um objecto requer mudanças a outros e você não sabe quantos outros objectos
devem mudar ou quando um objecto deve ser capaz de avisar outros sem fazer suposições sobre quem
são os objectos. Em outras palavras, sem criar um acoplamento forte entre os objectos.

4. Consequências
Possibilita baixo acoplamento entre os objectos dependentes (os observers) e o assunto.
Acoplamento abstrato.
Suporte para broadcast.
Dificuldade em saber o que foi mudado.