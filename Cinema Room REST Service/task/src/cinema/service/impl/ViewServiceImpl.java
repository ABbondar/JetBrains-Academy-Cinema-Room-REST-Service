package cinema.service.impl;

import cinema.dao.ViewDao;
import cinema.model.View;
import cinema.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {

    private final ViewDao viewDao;

    @Autowired
    public ViewServiceImpl(ViewDao viewDao) {
        this.viewDao = viewDao;
    }

    @Override
    public View getCinema() {
        return viewDao.getCinema();
    }
}