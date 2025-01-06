@echo off
setlocal

REM Diretório do projeto
set PROJECT_DIR=%~dp0

REM Entrar no diretório do projeto
cd /d %PROJECT_DIR%

REM Limpar e compilar o projeto com Maven
echo Compilando o projeto...
mvn clean install

if %ERRORLEVEL% NEQ 0 (
    echo Erro na compilação do projeto.
    exit /b %ERRORLEVEL%
)

REM Executar testes
echo Executando testes...
mvn test

if %ERRORLEVEL% NEQ 0 (
    echo Erro na execução dos testes.
    exit /b %ERRORLEVEL%
)

echo Processo concluído com sucesso.

REM Pausar para que a janela do prompt de comando permaneça aberta
pause

endlocal
