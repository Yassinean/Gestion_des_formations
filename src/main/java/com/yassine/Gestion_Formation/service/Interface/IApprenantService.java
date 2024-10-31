package com.yassine.Gestion_Formation.service.Interface;

import com.yassine.Gestion_Formation.model.Apprenant;

public interface IApprenantService {
    Apprenant registerApprenant(Apprenant apprenant);
    Apprenant findById(Long id);

}
