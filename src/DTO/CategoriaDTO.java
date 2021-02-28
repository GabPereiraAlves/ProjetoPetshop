
package DTO;

public class CategoriaDTO {
    private String servico, raca;
    private int id_servico, id_raca;

    /**
     * @return the servico
     */
    public String getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(String servico) {
        this.servico = servico;
    }

    /**
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the id_servico
     */
    public int getId_servico() {
        return id_servico;
    }

    /**
     * @param id_servico the id_servico to set
     */
    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    /**
     * @return the id_raca
     */
    public int getId_raca() {
        return id_raca;
    }

    /**
     * @param id_raca the id_raca to set
     */
    public void setId_raca(int id_raca) {
        this.id_raca = id_raca;
    }
    
}
