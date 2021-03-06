package com.mymovies.services.impl;

import java.util.ArrayList;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mymovies.models.MovieTvShow;
import com.mymovies.models.User;
import com.mymovies.models.UserMovieTvShow;
import com.mymovies.repositories.UserMovieTvShowRepository;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.services.UserMovieTvShowService;
import com.mymovies.services.UserService;
import com.mymovies.web.dtos.UserMovieTvShowDTO;
@Service

public class UserMovieTvShowServiceImpl implements UserMovieTvShowService {

	@Autowired
	UserMovieTvShowRepository umtsr;
	
	@Autowired
	MovieTvShowService mtss;
	
	@Autowired
	UserService us;
	
	@Value("${newRating}")
	 private String newRatingParam;
	 @Value("${watchlist}")
	 private String watchlistParam;
	 @Value("${watchlater}")
	 private String watchlaterParam;
	 
	@Override
	public List<UserMovieTvShow> getAll() {
		return umtsr.findAll();
	}

	@Override
	public UserMovieTvShow getById(long id) {
		return umtsr.findById(id).orElse(null);
	}

	@Override
	public UserMovieTvShow create(UserMovieTvShowDTO obj) {
		if(obj!=null&&obj.getMovieTvShow()!=null&&obj.getUser()!=null) {
			MovieTvShow mts = mtss.getById(obj.getMovieTvShow().getId());
			User user = us.getById(obj.getUser().getId());
			if(mts!=null&&user!=null) {
				UserMovieTvShow umts = new UserMovieTvShow();
				umts.setUserRating(obj.getUserRating());
				umts.setWatchLater(obj.isWatchLater());
				umts.setWatchlist(obj.isWatchlist());
				umts.setReviewed(obj.isReviewed());
				umts.setUserReview(obj.getUserReview());
				umts.setMovieTvShow(mts);
				umts.setUser(user);
				return umtsr.save(umts);
			}
			
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		umtsr.deleteById(id);
		
	}

	@Override
	public UserMovieTvShow update(UserMovieTvShowDTO obj) {
		if(obj.getUser()!=null&&obj.getMovieTvShow()!=null) {
			UserMovieTvShow umts = findByUserEmailAndMovieTvShowId(obj.getUser().getEmail(),obj.getMovieTvShow().getId());
			if(umts!=null) {
				umts.setUserRating(obj.getUserRating());
				umts.setWatchLater(obj.isWatchLater());
				umts.setWatchlist(obj.isWatchlist());
				umts.setReviewed(obj.isReviewed());
				umts.setUserReview(obj.getUserReview());
				return umtsr.save(umts);
			}
		}
		
		return null;
		
	}

	@Override
	public List<UserMovieTvShowDTO> getAllDTOs(List<UserMovieTvShow> objs) {
		List<UserMovieTvShowDTO> dtos = new ArrayList<UserMovieTvShowDTO>();
		objs.forEach(el->{
			UserMovieTvShowDTO dto = new UserMovieTvShowDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public UserMovieTvShowDTO getSingleDTO(UserMovieTvShow obj) {
		UserMovieTvShowDTO dto = new UserMovieTvShowDTO(obj);
		return dto;
	}

	@Override
	public UserMovieTvShow findByUserEmailAndMovieTvShowId(String email, long mtsid) {
		return umtsr.findByUserEmailAndMovieTvShowId(email, mtsid);
	}
	
	@Override
	public void updateDetails(String email, long mtsId, int newRating,String param, boolean wlParam) {
		UserMovieTvShow umts = umtsr.findByUserEmailAndMovieTvShowId(email, mtsId);
		if(umts==null) {
			umts = new UserMovieTvShow();
			MovieTvShow mts = mtss.getById(mtsId);
			User user = us.findByEmail(email);
			
			umts.setMovieTvShow(mts);
			umts.setUser(user);
		}
		if(param.equals(newRatingParam))
			umts.setUserRating(newRating);
		else if(param.equals(watchlistParam))
			umts.setWatchlist(wlParam);
		else if(param.equals(watchlaterParam))
			umts.setWatchLater(wlParam);
		umtsr.save(umts);
	}

	@Override
	public List<UserMovieTvShow> findByMovieTvShowId(long mtsid) {
		return umtsr.findByMovieTvShowId(mtsid);
	}

	@Override
	public UserMovieTvShow findByUserEmail(String email) {
		return umtsr.findByUserEmail(email);
	}

	

}
