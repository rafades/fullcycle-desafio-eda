# fullcycle-desafio-eda

Desafio módulo **EDA - Event Driven Architecture**

Contém código de base disponibilizado em [https://github.com/devfullcycle/fc-eda](https://github.com/devfullcycle/fc-eda)

## Passos para execução

1. Subir o container:

    ``` bash
    docker compose up -d
    ```

2. Acessar o terminal do container goapp:

    ``` bash
    docker exec -it <container_id> bash
    ```

3. Executar main.go

    ``` bash
    go run cmd/walletcore/main.go
    ```
