# HR-System
Microsserviços de um sistema de RH feito em um curso da udemy.

Este projeto consiste em uma aplicação de micro-serviços orquestrados por Docker, projetada para gerenciar o registro de usuários e facilitar o processo de pagamento mensal de salários, integrado a sistemas ERP para recursos humanos.

## Funcionalidades Principais

- **Micro-serviços Orquestrados**: Utilizamos o Docker para orquestrar micro-serviços, proporcionando fácil execução e escalabilidade.

- **Registro de Usuário**: Micro-serviço dedicado ao registro e gerenciamento de usuários.

- **Conta de Pagamento Mensal**: Micro-serviço que acessa a API de usuários para criar contas de pagamento mensal, integrando-se a sistemas ERP.

## Como Usar

Caso queira rodar e testar o projeto em seu ambiente basta rodar o arquivo de compose, iniciando o download das imagens de cada micro-serviço que também pode ser encontrado no docker hub do usuario ```leobarreto```, desse modo sendo possivel testar cada funcionalidade. 

## Contribuição
Se deseja contribuir para o projeto, siga estas etapas:

Faça um fork do repositório.
Crie uma branch para sua contribuição: git checkout -b minha-contribuicao
Faça as alterações desejadas.
Faça commit das alterações: git commit -m 'Adiciona minha contribuição'
Envie as alterações para o seu fork: git push origin minha-contribuicao
Abra um Pull Request no repositório principal.
Problemas e Feedback
Se encontrar problemas ou tiver sugestões, por favor, abra uma issue.
