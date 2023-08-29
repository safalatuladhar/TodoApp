package Model;

public class Todo {
    private Long id;
    private String name;
    private String todo;
    private String status;

    public Todo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", todo='" + todo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Todo(Long id, String name, String todo, String status) {
        this.id = id;
        this.name = name;
        this.todo = todo;
        this.status = status;
    }
}
