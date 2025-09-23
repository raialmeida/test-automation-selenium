# Uma imagem base do Maven com Java
FROM maven:3.8.7-openjdk-18-slim

# Instalar dependências do Chrome e libs do sistema
RUN apt-get update && \
    apt-get install -y wget gnupg unzip curl \
    fonts-liberation libnss3 libxss1 libasound2 libatk-bridge2.0-0 libgtk-3-0 && \
    rm -rf /var/lib/apt/lists/*

# Install Chrome
RUN apt-get update && \
    apt-get install -y wget gnupg && \
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor > /usr/share/keyrings/google-chrome.gpg && \
    sh -c 'echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list' && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo pom.xml para o contêiner
COPY ./pom.xml /app

# Copie o código de teste para o contêiner
COPY src ./src

# Cria o pacote (JAR/WAR) sem rodar testes
RUN mvn package -DskipTests

# Compila o projeto sem rodar testes
RUN mvn compile -DskipTests