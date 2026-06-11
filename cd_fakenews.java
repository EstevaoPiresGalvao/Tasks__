import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String nomeUsuario = "", bioUsuario = "", verificacao_senha = "", senhaUsuario = "";
        boolean contaCriada = false, usuarioLogado = false, executarSistema = true, loop = false;

        while (executarSistema) {
            
            if (!usuarioLogado) {
                System.out.println("\n=================================");
                System.out.println("    REDE SOCIAL CONSCIENTE       ");
                System.out.println("=================================");
                System.out.printf("\nEscolha uma opção: \n");
                System.out.println("1. Criar Conta");
                System.out.println("2. Fazer Login");
                System.out.println("3. Sair do Programa");
                System.out.printf("\n - -> ");
                
                int opcaoDeslogado = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoDeslogado) {
                    case 1:
                        if (contaCriada) {
                            System.out.printf("\n\n[Erro] Só é permitido uma conta por dispositivo!");
                        } else {
                            System.out.printf("\nDigite o seu nome de usuário: ");
                            nomeUsuario = scanner.nextLine();
                            System.out.printf("Digite uma breve biografia: ");
                            bioUsuario = scanner.nextLine();
                            System.out.printf("Crie uma senha de acesso: ");
                            senhaUsuario = scanner.nextLine();
                            contaCriada = true;
                            System.out.printf("\n\n[Sucesso] Conta criada! Agora, faça o login para acessar o sistema.");
                        }
                        break;

                    case 2:
                        if (!contaCriada) {
                            System.out.printf("\n\n[Erro] Nenhuma conta cadastrada neste dispositivo. Crie uma conta!");
                        } else {
                            System.out.print("Usuário: ");
                            String loginUser = scanner.nextLine();
                            System.out.print("Senha: ");
                            String loginSenha = scanner.nextLine();

                            if (loginUser.equals(nomeUsuario) && loginSenha.equals(senhaUsuario)) {
                                usuarioLogado = true;
                                System.out.printf("\n\n[Sucesso] Login realizado! Bem-vindo de volta, " + nomeUsuario + ".");
                            } else {
                                System.out.printf("\n\n[Erro] Usuário ou senha incorretos!");
                            }
                        }
                        break;

                    case 3:
                        System.out.printf("\n\nEncerrando o programa. Até mais!");
                        executarSistema = false;
                        break;

                    default:
                        System.out.println("[Erro] Opção inválida!");
                        break;
                }
            } 
            
            else {
                System.out.println("\n=================================");
                System.out.println("    REDE SOCIAL CONSCIENTE       ");
                System.out.println("    Logado como: " + nomeUsuario);
                System.out.println("=================================");
                System.out.printf("\n\nEscolha uma opção: ");
                System.out.printf("\n1. Editar Perfil");
                System.out.printf("\n2. Criar Novo Post");
                System.out.printf("\n3. Compartilhar Notícia");
                System.out.printf("\n4. Excluir Conta");
                System.out.printf("\n5. Sair da Conta (Logoff)");
                System.out.print("\n - -> ");

                int opcaoLogado = scanner.nextInt();
                scanner.nextLine();
                
                do{
                switch (opcaoLogado) {
                    case 1:
                        System.out.print("O que você deseja modificar ? ");
                        System.out.println("1. Nome de usuário");
                        System.out.println("2. Biografia");
                        System.out.println("3. Senha");
                        System.out.print("\n\n - ->");
                        opcaoLogado = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("\n\nDigite sua senha: ");
                        verificacao_senha = scanner.nextLine(); //terminar
                        
                        if (verificacao_senha.equals(senhaUsuario)){
                        switch (opcaoLogado){
                            case 1:
                                System.out.printf("\n\nInforme novo nome de usuário: ");
                                nomeUsuario = scanner.nextLine();
                                break;
                                
                                case 2:
                                    System.out.printf("\n\nInforme nova biografia: ");
                                    bioUsuario = scanner.nextLine();
                                    break;
                                
                                        case 3:
                                            System.out.printf("\n\nInforme nova Senha: ");
                                            senhaUsuario = scanner.nextLine();
                        }
                        }
                        else{
                            System.out.print("Senha incorreta.");
                        }
                        System.out.println("--- Perfil Editado ---");
                        break;

                    case 2: 
                        System.out.print("\n\nDigite o conteúdo do seu novo post: ");
                        String novoPost = scanner.nextLine();
                        System.out.println("[Sucesso] Post publicado por " + nomeUsuario + ": \"" + novoPost + "\"");
                        break;

                    case 3: 
                        do {
                        loop = false;
                        System.out.printf("\n--- SELECIONE UMA NOTÍCIA PARA COMPARTILHAR ---\n");
                        System.out.println("1. Cientistas descobrem nova forma de limpar plásticos dos oceanos.");
                        System.out.println("2. Uso de inteligência artificial na educação cresce 40% este ano.");
                        System.out.println("3. Projeto comunitário planta 10 mil árvores em áreas urbanas.");
                        System.out.print("\n\n - -> ");
                        
                        int escolhaNoticia = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        String noticiaSelecionada = "";
                        if (escolhaNoticia == 1) {
                            noticiaSelecionada = "Cientistas descobrem nova forma de limpar plásticos dos oceanos.";
                            System.out.println("[ERRO] Essa notícia é falsa! Ela não tem nenhum embasamento ou veículo confiável, você pensou em checar as fontes antes? Hoje a IA faz isso facinho, se liga!");
                        } else if (escolhaNoticia == 2) {
                            noticiaSelecionada = "Uso de inteligência artificial na educação cresce 40% este ano.";
                            System.out.println("[ATENÇÃO] De fato essa notícia é verdadeira, mas o que te deu base para compartilhar? Você consultou alguma fonte confiável? Hoje a IA faz isso facinho, fica a dica!");
                        } else if (escolhaNoticia == 3) {
                            noticiaSelecionada = "Projeto comunitário planta um milhão de árvores em áreas urbanas.";
                            System.out.println("[ERRO FATAL] Essa notícia é falsa! Percebes o quão sensasionalista ela é? E você checou as fontes antes? Hoje a IA faz isso facinho, se liga!");
                        } else {
                            System.out.println("[Erro] Opção de notícia inválida!");
                            loop = true;
                        }
                        }while(loop = true);
                        break;

                    case 4: 
                        System.out.printf("\n\nTem certeza que deseja excluir sua conta? (S/N): ");
                        String confirmacao = scanner.nextLine();
                        if (confirmacao.equalsIgnoreCase("S")) {
                            nomeUsuario = "";
                            bioUsuario = "";
                            senhaUsuario = "";
                            contaCriada = false;
                            usuarioLogado = false;
                            System.out.println("[Sucesso] Sua conta foi excluída permanentemente.");
                        } else {
                            System.out.println("[Aviso] Exclusão cancelada.");
                        }
                        break;

                    case 5: 
                        usuarioLogado = false;
                        System.out.printf("\n\n[Info] Você saiu da sua conta com sucesso.");
                        break;

                    default:
                        loop = true;
                        System.out.printf("\n\n[Erro] Opção inválida, tente novamente:");
                        break;
                }
                }while(loop == true);
            }
        }
        scanner.close();
    }
}