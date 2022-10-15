package cinema.service.impl;

import cinema.dao.CinemaDao;
import cinema.model.Cinema;
import cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaDao cinemaDao;

    @Autowired
    public CinemaServiceImpl(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @Override
    public Cinema getCinema() {
        return cinemaDao.getCinema();
    }
}