package exercicio;

import java.util.List;

public class Programa {
    public static void main(String[] args) {

        CursoDAO cursoDAO = new CursoDAO();

        // =========================== Inserção =================================================
//        Curso cursoParaInsercao = new Curso(
//                "Geografia",
//                30
//        );
//
//        cursoDAO.create(cursoParaInsercao);
        // =========================== Delete =================================================

//        cursoDAO.delete();

        // =========================== Atualizar ================================================

//        Curso cursoParaAtualizar = cursoDAO.getById();
//        cursoParaAtualizar.setNome();
//        cursoParaAtualizar.setDuracaoHoras();
//        cursoParaAtualizar.setIdAuxiliar();
//
//        cursoDAO.update(cursoParaAtualizar);

        // ======================= Consulta com filtro ========================================

//        Curso cursoParaConsulta = cursoDAO.getById();
//        System.out.println(cursoParaConsulta);

        // =========================== Consulta =================================================
        List<Curso> cursos = cursoDAO.list();

        cursos.forEach(System.out::println);

    }
}
