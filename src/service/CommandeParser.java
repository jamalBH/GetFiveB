package service;

public class CommandeParser
{
    private Integer id;

    private Integer qte;

    private String name ;
    private float prix ;
    private String type ;

    
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getQte() {
		return qte;
	}



	public void setQte(Integer qte) {
		this.qte = qte;
	}



	@Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", qte = "+qte+"]";
    }
}