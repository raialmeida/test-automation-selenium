# Test Automation With Selenium
Test automation with Selenium WebDriver

[![Github Pipelines](https://github.com/raialmeida/test-automation-selenium/actions/workflows/selenium.yml/badge.svg?)](https://github.com/raialmeida/test-automation-selenium/actions/workflows/selenium.yml)
[![Azure Pipelines](https://dev.azure.com/COREQA/Automation/_apis/build/status%2Fraialmeida.test-automation-selenium?branchName=master)](https://dev.azure.com/COREQA/Automation/_build/latest?definitionId=6&branchName=master)

## 📌 Descrição

Este projeto é uma solução de automação de testes utilizando Java, Maven e Selenium WebDriver, configurada para rodar localmente ou em containers Docker.
Inclui integração com Allure Reports para geração de relatórios e pipelines de CI/CD com GitHub Actions, Azure Pipelines e Jenkins.

⚠️ Importante: este projeto contém apenas exemplos das principais interações com elementos comuns em plataformas web, servindo como base para criação de novas automações.

## ✅ Requisitos

Antes de rodar o projeto, instale:

- [Java 21](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://docs.docker.com/get-docker/)(Opcional)
- [Docker Compose](https://docs.docker.com/compose/)(Opcional)

## 🛠️ Tecnologias Utilizadas
- **Java 21**
- **Maven 3.9+**
- **Selenium WebDriver**
- **Chrome / ChromeDriver**
- **Docker / Docker Compose**
- **CI/CD: GitHub Actions | Azure Pipelines | Jenkins**
- **Allure Report**


## 📂 Estrutura do Projeto

````
src/
 ├─ main/java/com/automation
 │   ├── base        # Classes de configuração e suporte
 │   ├── pages       # Page Objects
 │   └── utils       # Utilitários e extensões
 │
 └── test/java/com/automation/tests   # Classes de testes
````

## 🌍 Variáveis de Ambiente
- **HEADLESS**: controla se o navegador Chrome será executado em modo headless.  
  - Valor padrão: `false`  
  - Pode ser configurado via **Docker Compose** ou **Maven**:
```bash
# Maven
mvn test -Dheadless=true

# Docker Compose
environment:
  HEADLESS="true"

```

## ▶️ Executando Localmente

### Compilar projeto

````
mvn compile
````

### Executar os testes
````
mvn test
````

## ▶️ Executando Localmente com Docker

### Executar testes dentro do container
````
docker-compose run --rm selenium-web mvn test
````

## 📊 Relatórios de Testes

### Gerar relatório Allure e visualizar no navegador

O relatório fica salvo na pasta
target/allure-results, execute:

````
mvn allure:serve
````

## ✨ Links Úteis

GitHub Actions Workflow: [Pipeline](https://github.com/raialmeida/test-automation-selenium/actions)

Allure Report: publicado no branch gh-pages após cada build. [Acesse Report Allure](https://raialmeida.github.io/test-automation-selenium/)
