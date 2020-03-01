package challenge;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Jogador {

    private String nationality;
    private String club; //OBS: Existem jogadores sem club
    private String fullname;
    private BigDecimal eur_release_clause;
    private LocalDate birth_date;
    private BigDecimal eur_wage; //Para desempate
    private Integer age;

    public Jogador(String nationality, String club, String fullname, BigDecimal eur_release_clause, LocalDate birth_date, BigDecimal eur_wage, Integer age) {
        this.nationality = nationality;
        this.club = club;
        this.fullname = fullname;
        this.eur_release_clause = eur_release_clause;
        this.birth_date = birth_date;
        this.eur_wage = eur_wage;
        this.age = age;
    }
    //<GETs>
    public String getNationality() {
        return nationality;
    }

    public String getClub() {
        return club;
    }

    public String getFullname() {
        return fullname;
    }

    public BigDecimal getEur_release_clause() {
        return eur_release_clause;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public BigDecimal getEur_wage() {
        return eur_wage;
    }

    public Integer getAge() {
        return age;
    }
    //<SETs>
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEur_release_clause(BigDecimal eur_release_clause) {
        this.eur_release_clause = eur_release_clause;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public void setEur_wage(BigDecimal eur_wage) {
        this.eur_wage = eur_wage;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogador)) return false;
        Jogador jogador = (Jogador) o;
        return getNationality().equals(jogador.getNationality()) &&
                getClub().equals(jogador.getClub()) &&
                getFullname().equals(jogador.getFullname()) &&
                getEur_release_clause().equals(jogador.getEur_release_clause()) &&
                getBirth_date().equals(jogador.getBirth_date()) &&
                getEur_wage().equals(jogador.getEur_wage()) &&
                getAge().equals(jogador.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNationality(), getClub(), getFullname(), getEur_release_clause(), getBirth_date(), getEur_wage(), getAge());
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nationality='" + nationality + '\'' +
                ", club='" + club + '\'' +
                ", fullname='" + fullname + '\'' +
                ", eur_release_clause=" + eur_release_clause +
                ", birth_date=" + birth_date +
                ", eur_wage=" + eur_wage +
                ", age=" + age +
                '}';
    }
}
