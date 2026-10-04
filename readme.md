# Cp2-SpringBoot

CRUD de pedido. Checkpoint FIAP: um recurso HTTP, serviço e JPA em memória.

Pacote `br.com.fiap.Checkpoint2`. O `pom` declara web, `spring-boot-starter-data-jpa` e H2. Java 21.

## Rotas

`OrderController`, base `/orders`. O controller chama `OrderService`; não fala com o repositório.

| Método | Rota | Método Java |
|---|---|---|
| POST | `/orders` | `creatOrder` |
| GET | `/orders` | `readOrders` |
| GET | `/orders/{id}` | `getOrder` |
| PUT | `/orders/{id}` | `updateOrder` |
| DELETE | `/orders/{id}` | `deletOrder` |

A entidade é `OrderModel`. Não há segundo recurso, não há autenticação, não há migration. H2 sobe com a aplicação e esvazia quando o processo cai, salvo o properties ter mudado o banco para arquivo.

## Como rodar

```bash
git clone https://github.com/Geronimo-augusto/Cp2-SpringBoot.git
cd Cp2-SpringBoot
./mvnw spring-boot:run
```

Porta padrão do Spring Boot: `8080`.

```bash
curl -X POST http://localhost:8080/orders -H 'Content-Type: application/json' -d '{"campo":"ver OrderModel"}'
curl http://localhost:8080/orders
```

O corpo do POST é o de `OrderModel`. Os nomes dos campos estão na classe, não neste README.

## Limites conhecidos

- Nomes `creatOrder` e `deletOrder` são os do código.
- Sem teste e sem perfil de banco externo.

## Integrantes
Geronimo - rm557170<br>
Ana Laura - rm554375<br>
Murilo Cordeiro - rm556727<br>
Ianny Raquel - rm559096# Cp2-SpringBoot
