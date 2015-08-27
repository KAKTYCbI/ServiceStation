package sjc.sample.app.repository.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.dozer.Mapping;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="director")
@PrimaryKeyJoinColumn(name = "user_id")
public class DirectorEntity extends UserPrincipalEntity {

	/*@Mapping("salary")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "director", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<SalaryEntity> salarys;

	public List<SalaryEntity> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<SalaryEntity> salarys) {
		this.salarys = salarys;
	}*/
	


	
	

}
