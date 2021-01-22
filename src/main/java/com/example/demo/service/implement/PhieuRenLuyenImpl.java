package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ChiTietPhieuRenLuyen;
import com.example.demo.entity.PhieuRenLuyen;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.PhieuRenLuyenRepository;
import com.example.demo.service.PhieuRenLuyenService;
@Service
public class PhieuRenLuyenImpl implements PhieuRenLuyenService{
	private final PhieuRenLuyenRepository phieuRenLuyenRepository;
	public PhieuRenLuyenImpl(PhieuRenLuyenRepository phieuRenLuyenRepository) {
		super();
		this.phieuRenLuyenRepository = phieuRenLuyenRepository;
	}
	@Override
	public List<PhieuRenLuyen> getAll() {
		// TODO Auto-generated method stub
		return phieuRenLuyenRepository.findAllByOrderByIdPhieuRenLuyenAsc();
	}
	@Override
	public Optional<PhieuRenLuyen> getByID(long id) {
		// TODO Auto-generated method stub
		return phieuRenLuyenRepository.findById(id);
	}
	@Override
	public PhieuRenLuyen setData(PhieuRenLuyen phieuRenLuyen) {
		// TODO Auto-generated method stub
		return phieuRenLuyenRepository.save(phieuRenLuyen);
	}
	@Override
	public Optional<PhieuRenLuyen> update(PhieuRenLuyen phieuRenLuyen) {
		return phieuRenLuyenRepository.findById(phieuRenLuyen.getIdPhieuRenLuyen()).map(phieurenluyen -> {
			phieurenluyen = phieuRenLuyen;
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
	}
	@Override
	public Optional<PhieuRenLuyen> updateDuyetLan2(long IdPhieu) {
		return phieuRenLuyenRepository.findById(IdPhieu).map(phieurenluyen -> {
			
			phieurenluyen.setDaDuyetLan2(!phieurenluyen.getDaDuyetLan2());
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
	}
	@Override
	public Optional<PhieuRenLuyen> updateDuyetLan2True(Long idPhieu) {
		
		return phieuRenLuyenRepository.findById(idPhieu).map(phieurenluyen -> {
			
			phieurenluyen.setDaDuyetLan2(true);
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
		
	}
	@Override
	public Optional<Object> delete(Long id) {
		return phieuRenLuyenRepository.findById(id).map(phieurenluyen -> {
			phieuRenLuyenRepository.delete(phieurenluyen);
			return ResponseEntity.ok().build();
		});
	}
	@Override
	public Optional<PhieuRenLuyen> updateDuyetLan3(long IdPhieu) {
		return phieuRenLuyenRepository.findById(IdPhieu).map(phieurenluyen -> {
			
			phieurenluyen.setDaDuyetLan3(!phieurenluyen.getDaDuyetLan3());
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
	}
	@Override
	public Optional<PhieuRenLuyen> updateDuyetLan3True(Long idPhieu) {
		
		return phieuRenLuyenRepository.findById(idPhieu).map(phieurenluyen -> {
			
			phieurenluyen.setDaDuyetLan3(true);
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
		
	}
	
	@Override
	public void updateTongDiemLan3(Integer tongdiem3, Long id) {
		// TODO Auto-generated method stub
		phieuRenLuyenRepository.updateTongDiemLan3(tongdiem3, id);
	}
	
	
	@Override
	public Optional<PhieuRenLuyen> updateTongDiemLan33(Integer tongdiem3, Long id) {
		// TODO Auto-generated method stub
		return phieuRenLuyenRepository.findById(id).map(phieurenluyen -> {
			phieurenluyen.setTongDiemLan3(tongdiem3);
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
	
	
		
	}
	
	@Override
	public Optional<PhieuRenLuyen> updateTongDiemLan1(Integer tongdiem1, Long id) {
		// TODO Auto-generated method stub
		return phieuRenLuyenRepository.findById(id).map(phieurenluyen -> {
			phieurenluyen.setTongDiemLan1(tongdiem1);
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
		
	}
	
	@Override
	public List<PhieuRenLuyen> getPhieuRenLuyen(String msv) {
		// TODO Auto-generated method stub
		return phieuRenLuyenRepository.findByDaDuyetLan2TrueAndMaSinhVienLike(msv);
	}
	@Override
	public Optional<PhieuRenLuyen> updateTongDiemLan2(Integer tongdiem2, Long id) {
		return phieuRenLuyenRepository.findById(id).map(phieurenluyen -> {
			phieurenluyen.setTongDiemLan2(tongdiem2);
			return phieuRenLuyenRepository.save(phieurenluyen);
		});
	}
	
}

	