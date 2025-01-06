# 🚀 Configurador de Pipeline CI/CD

## 📋 Índice
- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Requisitos do Sistema](#-requisitos-do-sistema)
- [Instalação](#-instalação)
- [Como Usar](#-como-usar)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Troubleshooting](#-troubleshooting)
- [Contribuição](#-contribuição)
- [Licença](#-licença)

## 🎯 Sobre o Projeto

O Configurador de Pipeline CI/CD é uma aplicação Java  que permite criar e configurar pipelines de integração e entrega contínua de forma simples e intuitiva. 
Com ela, você pode gerar configurações para Jenkins e Docker sem precisar editar arquivos manualmente.

## ✨ Funcionalidades

### Interface Gráfica 🖥️
- Formulário intuitivo para inserção de dados
- Visualização em tempo real do status das operações
- Suporte a múltiplos projetos

### Configurações Suportadas 🛠️
- **Ferramentas de Build:**
  - Maven 📦
  - Gradle 🐘
  - npm 📚

### Recursos Principais 🌟
- Geração automática de Jenkinsfile
- Configuração de Docker (opcional)
- Inicialização de repositório Git
- Validação de inputs
- Log de operações

## 💻 Requisitos do Sistema

- Java Development Kit (JDK) 17 ou superior
- Git instalado no sistema
- Ambiente gráfico para execução do Swing
- 512MB de RAM (mínimo)
- 100MB de espaço em disco

## 🚀 Instalação

1. **Clone o repositório:**
```bash
git clone https://bulletdev/pipeline-configurator.git
cd pipeline-configurator
```

2. **Compile o projeto:**
```bash
javac PipelineConfigApp.java
```

3. **Execute a aplicação:**
```bash
java PipelineConfigApp
```

## 📖 Como Usar

### 1. Configuração Inicial 🎮
1. Abra a aplicação
2. Preencha os campos obrigatórios:
   - Nome do Projeto
   - URL do Repositório
   - Branch (padrão: main)

### 2. Configuração do Build 🔧
1. Selecione a ferramenta de build (Maven, Gradle ou npm)
2. Configure os comandos de build desejados
3. Marque a opção Docker se desejar incluir configurações de containerização

### 3. Geração do Pipeline ⚡
1. Clique no botão "Create Pipeline"
2. Aguarde a conclusão do processo
3. Verifique os arquivos gerados na pasta `pipeline-configs/[nome-do-projeto]`


## ❗ Troubleshooting

### Possiveis Features e Soluções 🔍

1. **Erro ao inicializar Git**
   - Verifique se o Git está instalado
   - Confirme as permissões do diretório

2. **Interface não carrega**
   - Verifique a versão do Java
   - Confirme se há ambiente gráfico disponível

3. **Erro na geração de arquivos**
   - Verifique permissões de escrita
   - Confirme se o diretório não está em uso

## 🤝 Contribuição

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

💡 **Dica:** Mantenha sempre sua versão do Java atualizada para melhor compatibilidade.

📫 **Contato:** Para sugestões ou problemas, abra uma [issue](https://github.com/bulletdev/pipeline-configurator/issues).

🌟 Se este projeto ajudou você, considere dar uma estrela no GitHub!