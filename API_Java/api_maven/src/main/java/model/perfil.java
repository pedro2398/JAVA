package model;

public class perfil {

	private String name;
	private String public_repos;
	private String followers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublic_repos() {
		return public_repos;
	}
	public void setPublic_repos(String public_repos) {
		this.public_repos = public_repos;
	}
	public String getFollowers() {
		return followers;
	}
	public void setFollowers(String followers) {
		this.followers = followers;
	}
	

    public String toString() {
        return "Perfil [nome =" + name + ", repositorios = " + public_repos + ", seguidores = " + followers + "]";
    }
}

	
