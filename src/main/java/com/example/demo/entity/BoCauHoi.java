package com.example.demo.entity;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bo_cau_hoi")
public class BoCauHoi{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoCauHoi;

    @Column(name = "ten_bo_cau_hoi")
    private String tenBoCauHoi;

    @Column(name = "tinh_trang")
    private Boolean tinhTrang;

    @OneToMany(mappedBy = "idBoCauHoi",cascade = CascadeType.ALL)
    private List<CauHoi> cauHois = new ArrayList<>();

	public BoCauHoi(Long idBoCauHoi, String tenBoCauHoi, Boolean tinhTrang) {
		super();
		this.idBoCauHoi = idBoCauHoi;
		this.tenBoCauHoi = tenBoCauHoi;
		this.tinhTrang = tinhTrang;
	}
	public BoCauHoi() {
		super();
	}

	

	public Long getIdBoCauHoi() {
		return idBoCauHoi;
	}
	public void setIdBoCauHoi(Long idBoCauHoi) {
		this.idBoCauHoi = idBoCauHoi;
	}
	public String getTenBoCauHoi() {
		return tenBoCauHoi;
	}

	public void setTenBoCauHoi(String tenBoCauHoi) {
		this.tenBoCauHoi = tenBoCauHoi;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public List<CauHoi> getCauHois() {
		return cauHois;
	}
	public void setCauHois(List<CauHoi> cauHois) {
		this.cauHois = cauHois;
	}

	

	/*
	 * public void setCauHois(Set<CauHoi> cauHois) { this.cauHois = cauHois; }
	 */


}
