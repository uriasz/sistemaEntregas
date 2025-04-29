# Sistema de Pedidos

Este projeto simula um sistema de pedidos onde um **cliente** pode criar pedidos e acompanhar as mudanças de estado desses pedidos por meio de notificações automáticas. O sistema implementa o padrão de design **State** para gerenciar os estados de um pedido e o padrão **Observer** para notificar o cliente sobre qualquer alteração.

## Funcionalidades

- **Criação de pedidos**: Permite que um cliente crie pedidos.
- **Mudança de estados do pedido**: Cada pedido pode passar por diferentes estados: Criado, Em Preparação, Em Rota de Entrega e Entregue.
- **Notificações automáticas**: Sempre que o estado de um pedido muda, o cliente é notificado.
- **Suporte a múltiplos pedidos**: Um cliente pode ter vários pedidos e receber notificações individuais para cada um deles.

## Arquitetura do Sistema

O sistema é estruturado de maneira modular, com diferentes pacotes para separar as responsabilidades:

### Pacotes

1. **`pedido`**: Contém as classes e interfaces relacionadas aos pedidos e seus estados.
2. **`cliente`**: Contém a classe `Cliente`, responsável por armazenar notificações de pedidos.
3. **`factory`**: Contém a classe `PedidoFactory`, que é responsável pela criação de novos pedidos.
4. **`main`**: Contém a classe `Main` que serve para testar a criação de pedidos e as transições de estado.
5. **`teste`**: Contém os testes unitários que verificam o correto funcionamento do sistema.

### Classes Principais

- **Pedido**: Representa um pedido que possui um estado e está associado a um cliente. O pedido notifica o cliente sempre que seu estado muda.
  
- **PedidoEstado**: Interface que define os métodos para obter o nome do estado do pedido.
  
- **PedidoEstadoCriado** / **PedidoEstadoEmPreparacao** / **PedidoEstadoEmRota** / **PedidoEstadoEntregue**: Cada uma dessas classes representa um estado distinto de um pedido.
  
- **Cliente**: Representa um cliente que pode ter múltiplos pedidos. Quando o estado de um pedido muda, o cliente é notificado.
  
- **PedidoFactory**: Classe de fábrica que facilita a criação de novos pedidos associados a um cliente.

- **Main**: Classe principal onde o fluxo de criação e transição de estados de pedidos é testado e executado.

- **PedidoTest**: Conjunto de testes unitários que verificam o funcionamento correto do sistema, garantindo que os pedidos mudem de estado corretamente e que as notificações sejam enviadas.

## Estrutura de Pastas

A estrutura de pastas do projeto é a seguinte:

```
.
├── cliente
│   └── Cliente.java
├── factory
│   └── PedidoFactory.java
├── main
│   └── Main.java
├── pedido
│   ├── Pedido.java
│   ├── PedidoEstado.java
│   ├── PedidoEstadoCriado.java
│   ├── PedidoEstadoEmPreparacao.java
│   ├── PedidoEstadoEmRota.java
│   └── PedidoEstadoEntregue.java
├── teste
│   └── PedidoTest.java
└── pom.xml
```

### Descrição das Pastas e Arquivos

- **`cliente/Cliente.java`**: Contém a classe `Cliente`, que representa o cliente do sistema e armazena suas notificações.
  
- **`factory/PedidoFactory.java`**: Contém a classe `PedidoFactory`, que é responsável pela criação dos pedidos.
  
- **`main/Main.java`**: Contém a classe `Main`, onde a execução principal do sistema acontece.
  
- **`pedido/Pedido.java`**: Contém a classe `Pedido`, que representa um pedido e gerencia seu estado.
  
- **`pedido/PedidoEstado.java`**: Interface que define os métodos para os diferentes estados de um pedido.
  
- **`pedido/PedidoEstadoCriado.java`**, **`pedido/PedidoEstadoEmPreparacao.java`**, **`pedido/PedidoEstadoEmRota.java`**, **`pedido/PedidoEstadoEntregue.java`**: Contêm as implementações dos estados do pedido, cada uma representando um estado distinto.
  
- **`teste/PedidoTest.java`**: Contém os testes unitários que garantem que o sistema funcione corretamente.

- **`pom.xml`**: Arquivo de configuração do Maven, que define as dependências e configurações para compilar e executar o projeto.

## Fluxo de Execução

Ao executar a classe `Main`, o seguinte fluxo acontece:

1. **Criação do cliente**: Um cliente chamado **Ana** é criado.
2. **Criação do pedido**: Um pedido é criado e associado ao cliente **Ana**.
3. **Mudanças de estado do pedido**: O estado do pedido é alterado várias vezes, passando por "Criado", "Em Preparação", "Em Rota de Entrega" e finalmente "Entregue".
4. **Notificação do cliente**: A cada mudança de estado do pedido, uma notificação é enviada ao cliente, informando sobre a alteração.

## Como Usar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio
   ```

2. **Compile e execute o projeto**:

   O projeto pode ser compilado e executado usando o **Maven**. Caso não tenha o Maven instalado, você pode seguir o [guia oficial](https://maven.apache.org/install.html) para instalá-lo.

   Primeiro, compile o projeto:

   ```bash
   mvn compile
   ```

   E depois execute:

   ```bash
   mvn exec:java
   ```

   Isso irá rodar a classe `Main`, que cria o cliente e o pedido, e transita entre os diferentes estados do pedido, notificando o cliente a cada mudança.

## Testes

Este projeto inclui uma suíte de testes automatizados, escritos utilizando o **JUnit 5**, para garantir que o sistema funcione corretamente. Os testes cobrem diversos cenários, como:

- **Verificar o estado inicial** do pedido (deve ser "Criado").
- **Mudança de estados** do pedido (de "Criado" para "Em Preparação", depois para "Em Rota de Entrega" e finalmente "Entregue").
- **Notificação do cliente** a cada mudança de estado do pedido.
- **Testes com múltiplos pedidos** para um único cliente.
- **Testar a mudança de estado com valor nulo** (não deve alterar o estado).

Para rodar os testes, basta executar o seguinte comando:

```bash
mvn test
```

Isso irá rodar todos os testes definidos na classe `PedidoTest`.

## Contribuindo

Se você gostaria de contribuir para o projeto, siga estas etapas:

1. **Faça um fork** do repositório.
2. **Crie uma branch** para a sua modificação (`git checkout -b minha-modificacao`).
3. **Faça commit** das suas mudanças (`git commit -am 'Adiciona nova funcionalidade'`).
4. **Faça push** para a sua branch (`git push origin minha-modificacao`).
5. **Abra um pull request** explicando as modificações.
