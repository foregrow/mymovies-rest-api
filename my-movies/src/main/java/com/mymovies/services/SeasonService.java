package com.mymovies.services;

import com.mymovies.models.Season;
import com.mymovies.web.dtos.SeasonDTO;

public interface SeasonService extends CrudService<Season, SeasonDTO>, DTOService<Season, SeasonDTO> {

}
