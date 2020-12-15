package com.mymovies.services;

import com.mymovies.models.Episode;
import com.mymovies.web.dtos.EpisodeDTO;

public interface EpisodeService extends CrudService<Episode, EpisodeDTO>, DTOService<Episode, EpisodeDTO> {

}
