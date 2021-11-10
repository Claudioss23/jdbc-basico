package exercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // 1 - Consulta
    public List<Curso> list() {
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactoryCurso.getConnection()) {
            PreparedStatement prst = conn.prepareStatement("SELECT * FROM curso");

            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("duracao_horas")
                );

                cursos.add(curso);
            }
        } catch (Exception e) {
            System.out.println("Consulta FALHOU!");
            e.printStackTrace();
        }
        return cursos;
    }

    //2 - Consulta com filtro
    public Curso getById(int id) {
        Curso curso = new Curso();

        try (Connection conn = ConnectionFactoryCurso.getConnection()) {
            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracao_horas"));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        return curso;
    }

    //3 - Inserção
    public void create (Curso curso) {
        try (Connection conn = ConnectionFactoryCurso.getConnection()) {
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 1) {
                System.out.println("Inserção BEM SUCEDIDA!. Foram adicionadas " + rowsAffected + " linhas");
            } else {
                System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
            }
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    //4 - Delete
    public void delete (int id) {
        try (Connection conn = ConnectionFactoryCurso.getConnection()) {
            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 1) {
                System.out.println("Delete BEM SUCEDIDA! Foram deletadas " + rowsAffected + " linhas");
            } else {
                System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
            }
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    //5 - Atualizar
    public void update (Curso curso) {
        try (Connection conn = ConnectionFactoryCurso.getConnection()) {
            String sql = "UPDATE curso SET id = ?, nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getIdAuxiliar());
            stmt.setString(2, curso.getNome());
            stmt.setInt(3, curso.getDuracaoHoras());
            stmt.setInt(4, curso.getId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 1) {
                System.out.println("Atualização BEM SUCEDIDA! Foram atualizadas: " + rowsAffected + " linhas");
            } else {
                System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
            }
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }
}
