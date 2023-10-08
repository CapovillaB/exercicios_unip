package com.unip.universidade.model.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unip.universidade.model.Aluno;

@Component
public class AlunoDAOImpl implements AlunoDAO {

    @Override
    public List<Aluno> listarAlunos() {
        List<Aluno> lista = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:C:/Users/elisa/Downloads/universidade", "teste", "teste");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from aluno");
            lista = new ArrayList<Aluno>();
            while (rs.next()) {
                lista.add(new Aluno(rs.getInt("matricula"), rs.getString("nome"), rs.getDate("data_nascimento")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean inserirAluno(Aluno aluno) {
        boolean retorno = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:C:/Users/elisa/Downloads/universidade", "teste", "teste");
            PreparedStatement pStat = conn.prepareStatement("insert into aluno(nome, data_nascimento) values (?, ?)");
            pStat.setString(1, aluno.getNome());
            pStat.setDate(2, new Date(aluno.getDataNascimento().getTime()));
            if (pStat.executeUpdate() > 0)
                retorno = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
}
