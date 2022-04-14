package net.crazyk.jpa.chapter09.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ValueTypeMember9 {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	@Embedded
	private ValueTypeAddress9 homeAddress;
	@ElementCollection
	@CollectionTable(
		name = "VT_FAVORITE_FOODS_9",
		joinColumns = @JoinColumn(name = "MEMBER_ID")
	)
	private Set<String> favoriteFoods = new HashSet<>();
	@ElementCollection(fetch = FetchType.LAZY) // 기본값이 LAZY
	@CollectionTable(
		name = "VT_ADDRESS",
		joinColumns = @JoinColumn(name = "MEMBER_ID")
	)
	private List<ValueTypeAddress9> addressHistory = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ValueTypeAddress9 getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(ValueTypeAddress9 homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Set<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	public List<ValueTypeAddress9> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<ValueTypeAddress9> addressHistory) {
		this.addressHistory = addressHistory;
	}
}
