
package view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;



public class CadastroDao {
    Connection con;
    Connection conn;
    PreparedStatement st;
    PreparedStatement st2;
    ResultSet rs;
    ResultSet rs2;
    
    public boolean conectar(){ // faz a conecção com o banco de dados:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aps","java","java");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aps","java","java");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    
    }
    public int salvar(Cadastros cadastros){ // salva as informações no banco de dados :
        int status,status2;

        try {
            st2 = conn.prepareStatement("INSERT INTO casos VALUES(?,?,?,?,?,?);");
            st2.setString(1,cadastros.getID());
            st2.setString(2,cadastros.getData());
            st2.setString(3,cadastros.getVirus());
            st2.setString(4,cadastros.getCPF());
            st2.setString(5,cadastros.getCidade());
            st2.setString(6,cadastros.getAndamento());
            st = con.prepareStatement("INSERT INTO dados VALUES(?,?,?,?);");
            st.setString(1,cadastros.getNome());
            st.setString(2,cadastros.getCPF());
            st.setString(3,cadastros.getIdade());
            st.setString(4,cadastros.getSexo());
            status = st.executeUpdate();// faz a primeira conexão com o banco de dados para inserir na tabela casos
            status2 = st2.executeUpdate(); //faz a segunda conexão com banco para inserir os dados na tabela dados
             
             
             
            return status;
        } catch (SQLException ex) {
            
            return ex.getErrorCode();
        // erro 1062 significa que ja existe o numero do I.D no banco de dados  na chave primaria 
            
        }
    }
    public void desconectar(){ // Desconecta do banco de dados.
        try {
            con.close();
        } catch (SQLException ex) {
            
        }
        
    }  
    
    
    public Cadastros buscar(String ID){
        
       Cadastros cadastros= new Cadastros();
        try {
            st = con.prepareStatement("SELECT * FROM dados LEFT JOIN casos ON casos_cpf = dados_cpf WHERE ID = ?");
            st.setString(1,ID);
            System.out.println(st);
            rs = st.executeQuery();
        // verifica se a aconsulta encontrou o cadastro com id informado
        if(rs.next()){// caso encontrado

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String stdata = sdf.format(rs.getDate("data"));
            System.out.println(stdata);
            
            cadastros.setNome(rs.getString("Nome"));
            cadastros.setCPF(rs.getString("dados_cpf"));
            cadastros.setIdade(rs.getString("Idade"));
            cadastros.setSexo(rs.getString("Sexo"));
            cadastros.setID(rs.getString("ID"));
            cadastros.setData(stdata);
            cadastros.setVirus(rs.getString("virus"));
            cadastros.setCidade(rs.getString("local"));
            
            
            
            cadastros.setAndamento(rs.getString("status"));
            return cadastros;
        }else{
            
            return null;    
         }    
        } catch (SQLException ex) {
            return null;    
        }
 }
    public Cadastros buscar2(String CPF){
        
        Cadastros cadastros= new Cadastros();
        try {
            st = con.prepareStatement("SELECT * FROM dados INNER JOIN casos ON casos_cpf = dados_cpf WHERE casos_cpf = ?");
            st.setString(1,CPF);
            rs = st.executeQuery();
        // verifica se a aconsulta encontrou o cadastro com CPF informado
        if(rs.next()){// caso encontrado
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String stdata = sdf.format(rs.getDate("data"));
            System.out.println(stdata);

            cadastros.setNome(rs.getString("Nome"));
            cadastros.setCPF(rs.getString("dados_cpf"));
            cadastros.setIdade(rs.getString("Idade"));
            cadastros.setSexo(rs.getString("Sexo"));
            cadastros.setID(rs.getString("ID"));
            cadastros.setData(stdata);
            cadastros.setVirus(rs.getString("virus"));
            cadastros.setCidade(rs.getString("local"));
            cadastros.setAndamento(rs.getString("status"));
            
            
            
            
            
            return cadastros;
        }else{
            return null;    
         }    
        } catch (SQLException ex) {
            return null;    
        }
 }
    public Cadastros buscar3(String virus){
        Cadastros cadastros= new Cadastros();
       int resultado;
       String teste;
       
        try {
            st = con.prepareStatement("SELECT COUNT(*) FROM casos WHERE virus = ?");
            st.setString(1,virus);
            rs = st.executeQuery();
       
        // verifica se a aconsulta encontrou o cadastro com id informado
        if(rs.next()){// caso encontrado
            
            resultado = rs.getInt(1);
            teste = Integer.toHexString(resultado);
            cadastros.setTxtReturnoCaso(teste);
            System.out.println(teste);
             return cadastros;
        }else{
            return null;    
         }    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,null, JOptionPane.INFORMATION_MESSAGE);
            return null;    
        }
        
       
    }
    public boolean excluir(String ID,String CPF){ // Faz a ligação par excluir itens do banco
        
        try {
            st = con.prepareStatement("DELETE FROM casos WHERE ID = ? ");
            st.setString(1, ID);
            st.executeUpdate();
            st2 = conn.prepareStatement("DELETE FROM dados WHERE dados_cpf = ? ");
            st2.setString(1, CPF);
            st2.executeUpdate();
            
            return true;
        
        } catch (SQLException ex) {
            return false;
        }
        
        
    }
    
    public int alterar(Cadastros cadastros) {
        int status,status2;
        
        try {
            st2 = conn.prepareStatement("UPDATE casos SET data = ?, virus = ?, casos_cpf = ?, local = ?, status = ? WHERE ID = ?");
            st2.setString(6,cadastros.getID());
            st2.setString(1,cadastros.getData());
            st2.setString(2,cadastros.getVirus());
            st2.setString(3,cadastros.getCPF());
            st2.setString(4,cadastros.getCidade());
            st2.setString(5,cadastros.getAndamento());
            st = con.prepareStatement("UPDATE dados SET Nome = ?, Idade = ?, Sexo = ? WHERE dados_cpf = ?;");
            st.setString(1,cadastros.getNome());
            st.setString(2,cadastros.getIdade());
            st.setString(3,cadastros.getSexo());
            st.setString(4,cadastros.getCPF());
            status = st.executeUpdate();// faz a primeira conexão com o banco de dados para inserir na tabela casos
            status2 = st2.executeUpdate(); //faz a segunda conexão com banco para inserir os dados na tabela dados
             
             
             
            return status;
        } catch (SQLException ex) {
             
            
            return ex.getErrorCode();
        // erro 1062 significa que ja existe o numero do I.D no banco de dados  na chave primaria 
            
        }
    }
    
    public int[] buscarDash(String local, String inicio, String fim) {
      
        int vetResp[] = new int[28];
        String x = "";

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Covid-19' AND data BETWEEN ? AND ? AND (local = ";
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[0] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Dengue' AND data BETWEEN ? AND ? AND (local = ";
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[1] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'H1N1'AND data BETWEEN ? AND ? AND (local = ";
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[2] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }
        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Covid-19' AND status = 'Óbito' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[3] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Dengue' AND status = 'Óbito' AND data BETWEEN ? AND ?  AND (local = ";
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[4] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'H1N1' AND status = 'Óbito' AND data BETWEEN ? AND ?  AND (local = ";
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[5] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Covid-19' AND status = 'Curado' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[6] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Dengue' AND status = 'Curado' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[7] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'H1N1' AND status = 'Curado' AND data BETWEEN ? AND ?  AND (local = ";
            
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[8] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Covid-19' AND status = 'Tratando' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[9] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'Dengue' AND status = 'Tratando' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[10] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos WHERE virus = 'H1N1' AND status = 'Tratando' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[11] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Covid-19' AND Sexo = 'Masculino' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[12] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Dengue' AND Sexo = 'Masculino' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[13] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'H1N1' AND Sexo = 'Masculino' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[14] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Covid-19' AND Sexo = 'Feminino' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[15] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Dengue' AND Sexo = 'Feminino' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[16] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'H1N1' AND Sexo = 'Feminino' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[17] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Covid-19' AND Sexo = 'Transgênero' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[18] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Dengue' AND Sexo = 'Transgênero' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[19] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'H1N1' AND Sexo = 'Transgênero' AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[20] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Covid-19' AND Idade > 60 AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[21] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Dengue' AND Idade > 60 AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            System.out.println(st);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[22] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'H1N1' AND Idade > 60 AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[23] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Covid-19' AND Idade < 12 AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();
            // verifica se a aconsulta encontrou o resultado
            if (rs.next()) {// caso encontrado
                vetResp[24] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'Dengue' AND Idade < 12 AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[25] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }

        try {
            x = "SELECT COUNT(ID) FROM casos INNER JOIN dados ON dados_cpf = casos_cpf WHERE virus = 'H1N1' AND Idade < 12 AND data BETWEEN ? AND ?  AND (local = ";
            ;
            st = con.prepareStatement(x + local);
            st.setString(1, inicio);
            st.setString(2, fim);
            rs = st.executeQuery();

            if (rs.next()) {
                vetResp[26] = rs.getInt(1);
            }
        } catch (SQLException ex) {
             
        }
        for (int i = 0; i < 28; i++) {
            System.out.println(vetResp[i]);
        }
        return vetResp;

    }

   
      
}

    
        
        
    
            
            
    

