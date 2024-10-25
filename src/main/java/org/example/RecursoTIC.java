package org.example;

// La clase RecursoTIC representa un recurso tecnológico con sus propiedades básicas.
public class RecursoTIC {
    private String codigo;  // Identificador único para el recurso.
    private String nombre;  // Nombre del recurso.
    private String tipo;    // Tipo del recurso ("computadora", "proyector", etc.).
    private EstadoRecurso estado; // Estado del recurso (utilizando el Enum EstadoRecurso).

    // Constructor para inicializar un recurso TIC con sus atributos.
    public RecursoTIC(String codigo, String nombre, String tipo, EstadoRecurso estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Métodos getters para obtener los valores de los atributos.
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public EstadoRecurso getEstado() {
        return estado;
    }

    // Métodos setters para modificar los valores de los atributos.
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(EstadoRecurso estado) {
        this.estado = estado;
    }

    // Método toString para devolver una representación en String del recurso TIC.
    @Override
    public String toString() {
        return "RecursoTIC [Codigo=" + codigo + ", Nombre=" + nombre + ", Tipo=" + tipo + ", Estado=" + estado + "]";
    }
}
