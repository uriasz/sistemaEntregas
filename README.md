# Entregas - Sistema de Pedidos com Notificações

Este projeto é uma simulação de um sistema de gerenciamento de pedidos inspirado no funcionamento de aplicativos como o **iFood**.  
Ele foca em criar uma estrutura sólida, **extensível** e **orientada a padrões de projeto** para representar o ciclo de vida de um pedido, desde sua criação até a entrega, notificando os clientes interessados automaticamente em cada mudança.

Este documento explica **tudo**, de forma **profunda** e **profissional**: desde a organização das pastas até a análise detalhada de porque cada tecnologia e padrão foi utilizado.

---

## Visão Geral

O sistema modela:

- **Pedidos** que mudam de **estado** (por exemplo: "Em preparação", "Em rota de entrega", "Entregue").
- **Clientes** que querem ser informados quando o status dos seus pedidos muda.
- **Mensagens de notificação** enviadas para todos os clientes associados a um pedido.

O projeto é escrito em **Java 17+**, separado em camadas por **pacotes**, e aplicando **quatro Padrões de Projeto**: **Observer**, **State**, **Singleton** e **Factory Method**.

---

## Organização do Código

```
src/
├── main/
│   └── java/
│       ├── cliente/
│       │   └── Cliente.java
│       ├── factory/
│       │   └── PedidoFactory.java
│       ├── main/
│       │   └── Main.java
│       └── pedido/
│           ├── Pedido.java
│           ├── PedidoEstado.java
│           ├── PedidoEstadoCriado.java
│           ├── PedidoEstadoEmPreparacao.java
│           ├── PedidoEstadoEmRota.java
│           ├── PedidoEstadoEntregue.java
└── test/
    └── java/
        ├── cliente/
        │   └── ClienteTest.java
        ├── factory/
        │   └── PedidoFactoryTest.java
        └── pedido/
            ├── PedidoTest.java
            └── PedidoEstadoTest.java
```

Cada pacote tem uma responsabilidade clara:

| Pacote    | Responsabilidade                                    |
|-----------|-----------------------------------------------------|
| cliente   | Representa os clientes que recebem notificações.    |
| pedido    | Representa os pedidos, estados e a lógica de mudança. |
| factory   | Responsável pela criação controlada de objetos Pedido. |
| main      | Ponto de entrada da aplicação (simulação de uso).   |
| test      | Conjunto de testes unitários para validar o sistema. |

---

## Padrões de Projeto Aplicados e Justificativas

### 1. **Observer**

**Onde foi aplicado:**  
- `Pedido` (sujeito/subject) e `Cliente` (observadores).

**Por que foi aplicado:**  
Permite que os clientes sejam automaticamente notificados quando o pedido muda de estado.  
Isso evita um acoplamento forte entre a lógica de negócios e a camada de notificação, seguindo o princípio **Aberto/Fechado** do SOLID (pode-se adicionar novos tipos de clientes sem mudar o pedido).

**Benefícios:**
- Escalabilidade para múltiplos clientes.
- Facilita integrações futuras (como enviar notificações por email, app, SMS).
- Permite adicionar ou remover observadores dinamicamente.

---

### 2. **State**

**Onde foi aplicado:**  
- Interface `PedidoEstado` e as classes `PedidoEstadoCriado`, `PedidoEstadoEmPreparacao`, `PedidoEstadoEmRota`, `PedidoEstadoEntregue`.

**Por que foi aplicado:**  
Cada estado de um pedido encapsula seu comportamento. Ao invés de usar estruturas como `if-else` ou `switch-case`, o comportamento é delegado à própria classe do estado.

**Benefícios:**
- **Extensibilidade:** novos estados podem ser adicionados sem mudar o código do `Pedido`.
- **Clareza:** cada classe tem uma responsabilidade única.
- **Isolamento de mudanças:** Se a lógica de um estado mudar, apenas sua própria classe será alterada.

---

### 3. **Singleton**

**Onde foi aplicado:**  
- Cada classe que representa um estado (`PedidoEstadoCriado`, `PedidoEstadoEmPreparacao`, etc).

**Por que foi aplicado:**  
Como o estado é uma entidade estática e sem atributos variáveis, não faz sentido criar múltiplas instâncias iguais.  
O Singleton garante que apenas uma instância de cada estado exista no sistema.

**Benefícios:**
- Redução de uso de memória.
- Garante a unicidade do comportamento de cada estado.
- Facilita a comparação de estados (por identidade de instância).

---

### 4. **Factory Method**

**Onde foi aplicado:**  
- Classe `PedidoFactory`.

**Por que foi aplicado:**  
Centraliza a criação de objetos `Pedido`, preparando a arquitetura para cenários mais complexos onde a criação de pedidos poderia variar (ex.: criar pedidos de tipos diferentes, pedidos recuperados do banco de dados).

**Benefícios:**
- Desacoplamento da criação do objeto em relação à sua utilização.
- Facilita testes e manutenção.
- Permite criar diferentes tipos de pedidos no futuro.

---

## Explicação Técnica das Principais Classes

### Pedido.java

- Possui:
  - Um **estado atual** (`PedidoEstado`).
  - Uma **lista de clientes observadores**.
- Métodos principais:
  - `setEstado()`: altera o estado e dispara notificações.
  - `adicionarObservador()` e `removerObservador()`: gerenciam clientes interessados.
- Utiliza:
  - Padrão **Observer** para notificações.
  - Padrão **State** para gerenciar estados.

---

### PedidoEstado.java e implementações

- `PedidoEstado` é uma **interface** que obriga todos os estados a implementarem `getNomeEstado()`.
- Cada classe de estado é:
  - Um **Singleton** (controlado através de `getInstancia()`).
  - Responsável por retornar a descrição do estado (ex.: "Em Preparação").

---

### Cliente.java

- Armazena apenas o nome do cliente.
- Método `notificar(String mensagem)`:
  - Simula o envio de uma mensagem ao cliente.
  - Personaliza a mensagem com o nome do cliente.

---

### PedidoFactory.java

- Método estático `criarPedido()`.
- Responsável por criar novas instâncias de `Pedido`.

---

### Main.java

Demonstra o uso do sistema:

- Cria dois clientes.
- Cria um pedido.
- Associa os clientes ao pedido.
- Altera o estado do pedido várias vezes, imprimindo as mensagens de notificação para cada mudança.

---

## Fluxo de Execução

1. O sistema cria um `Pedido` usando a `PedidoFactory`.
2. O sistema adiciona clientes como observadores ao pedido.
3. Quando o estado do pedido muda:
   - O pedido atualiza seu estado interno.
   - Dispara notificações para todos os clientes cadastrados.

---

## Testes

Utilizamos o **JUnit 5** para criar uma bateria de testes:

- **ClienteTest:** Verifica se a notificação enviada para o cliente contém o nome e a mensagem corretos.
- **PedidoTest:**
  - Garante que adicionar e remover observadores funciona.
  - Garante que os observadores são notificados corretamente nas mudanças de estado.
- **PedidoEstadoTest:** Testa a resposta de `getNomeEstado()` para cada estado.
- **PedidoFactoryTest:** Verifica se a fábrica retorna um objeto não nulo de `Pedido`.

---

## Tecnologias Utilizadas

- Java 17+
- Maven (gestão de dependências e build)
- JUnit 5 (testes unitários)

---

## Melhorias Futuras Possíveis

- Criar novos tipos de clientes (ex.: empresas, entregadores).
- Melhorar o mecanismo de notificação (permitindo múltiplos canais).
- Criar um sistema de logs para registrar mudanças de estado.
- Implementar padrões como **Strategy** para diferentes tipos de notificação.
- Suporte a persistência (salvar pedidos e estados em banco de dados).
- Interfaces REST para integrar com um frontend.

---

## Considerações Finais

Este projeto é um exercício realista e profundo de boas práticas de arquitetura de software orientado a objetos.  
Cada decisão de projeto visa garantir:

- **Alta coesão** (cada classe faz apenas uma coisa).
- **Baixo acoplamento** (as classes dependem minimamente umas das outras).
- **Facilidade de manutenção e expansão**.
