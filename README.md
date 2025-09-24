# Test Automation Selenium
Test automation with Selenium WebDriver

[![Github Pipelines](https://github.com/raialmeida/test-automation-selenium/actions/workflows/selenium.yml/badge.svg?)](https://github.com/raialmeida/test-automation-selenium/actions/workflows/selenium.yml)
[![Azure Pipelines](https://dev.azure.com/COREQA/Automation/_apis/build/status%2Fraialmeida.test-automation-selenium?branchName=master)](https://dev.azure.com/COREQA/Automation/_build/latest?definitionId=6&branchName=master)

## Visão Geral
**`test-automation-selenium`** é um projeto de automação de testes para aplicações web usando **Java**, **Maven** e **Selenium WebDriver**, com suporte para **Docker**, **Docker Compose**, **GitHub Actions** (CI/CD) e geração de relatórios de testes via **Allure**.  

O projeto permite rodar testes tanto em modo local quanto em containers, garantindo consistência e portabilidade.

## Requisitos

Antes de rodar o projeto, instale:

- [Java 21](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://docs.docker.com/get-docker/)(Opciona)
- [Docker Compose](https://docs.docker.com/compose/)(Opcional)

## Tecnologias Utilizadas
- **Java 21**
- **Maven 3.8+**
- **Selenium WebDriver**
- **Chrome / ChromeDriver**
- **Docker / Docker Compose**
- **GitHub Actions** (CI/CD)
- **Allure Report**


## Estrutura do Projeto

````
src/
 ├─ main/java/com/automation
 │   ├── base        # Classes de configuração e suporte
 │   ├── pages       # Page Objects
 │   └── utils       # Utilitários e extensões
 │
 └── test/java/com/automation/tests   # Testes automatizados
````

## Variáveis de Ambiente
- **HEADLESS**: controla se o navegador Chrome será executado em modo headless.  
  - Valor padrão: `false`  
  - Pode ser configurado via **Docker Compose** ou **Maven**:
```bash
# Maven
mvn test -Dheadless=true

# Docker Compose
environment:
  - HEADLESS=true

```

## Executando Localmente

### Compilar projeto

````
mvn compile
````

### Executar os testes
````
mvn test
````

## Executando Localmente com Docker

### Executar testes dentro do container
````
docker-compose run --rm selenium-web mvn test
````

## Relatórios de Testes

### Gerar relatório Allure e visualizar no navegador

O relatório fica salvo na pasta
target/allure-results

````
mvn allure:serve
````

## Links Úteis

GitHub Actions Workflow: [Pipeline](https://github.com/raialmeida/test-automation-selenium/actions)

Allure Report: publicado no branch gh-pages após cada build. [Acesse Report Allure](https://raialmeida.github.io/test-automation-selenium/)
