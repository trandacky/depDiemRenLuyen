package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BoCauHoi;
import com.example.demo.repository.BoCauHoiRepository;
import com.example.demo.service.BoCauHoiService;
import com.example.demo.service.dto.BoCauHoiDTO;
@Service
public class BoCauHoiImpl implements BoCauHoiService {
	@Autowired
	private BoCauHoiRepository boCauHoiRepository;
	@Override
	public List<BoCauHoi> getAll() {return boCauHoiRepository.findAllByOrderByIdBoCauHoiAsc();}
	@Override
	public BoCauHoi setData(BoCauHoiDTO boCauHoiDTO) {
		BoCauHoi boCauHoi = new BoCauHoi(boCauHoiDTO.getIdBoCauHoi(), boCauHoiDTO.getTenBoCauHoi(),
				boCauHoiDTO.getTinhTrang());return boCauHoiRepository.save(boCauHoi);	}
	@Override
	public Optional<BoCauHoi> update(BoCauHoiDTO boCauHoiDTO) {
		BoCauHoi boCauHoi = new BoCauHoi(boCauHoiDTO.getIdBoCauHoi(), boCauHoiDTO.getTenBoCauHoi(),
				boCauHoiDTO.getTinhTrang());
		return boCauHoiRepository.findById(boCauHoi.getIdBoCauHoi()).map(bocauhoi -> {
			bocauhoi = boCauHoi;return boCauHoiRepository.save(bocauhoi);});	}
	@Override
	public Optional<Object> delete(Long id) {
		return boCauHoiRepository.findById(id).map(bocauhoi -> {
			boCauHoiRepository.delete(bocauhoi);return ResponseEntity.ok().build();	});	}
	@Override
	public BoCauHoi save(BoCauHoi boCauHoi) {return boCauHoiRepository.save(boCauHoi);}
	@Override
	public Optional<BoCauHoi> getByID(long id) {return boCauHoiRepository.findById(id);}
	@Override
	public List<BoCauHoi> getBoCauHoiTrue() {return boCauHoiRepository.findByTinhTrangTrue();}
	@Override
	public void updateTen(long id, String ten) {boCauHoiRepository.updateTenBoCauHoi(id, ten);}
	@Override
	public List<BoCauHoi> seach(String seachString) {
		long seachString2 = -17777777;
		if (isNumeric(seachString))
			seachString2 = Long.parseLong(seachString);
		seachString = "%" + seachString + "%";
		List<BoCauHoi> list;
		try {
			list = boCauHoiRepository.findByIdBoCauHoiOrTenBoCauHoiLike(seachString2, seachString);
		} catch (Exception e) {
			list = null;
		}
		return list;
	}
	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

}
