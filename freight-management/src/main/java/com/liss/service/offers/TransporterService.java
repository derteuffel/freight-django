package com.liss.service.offers;

import com.liss.httpException.HttpServiceExceptionHandle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;

@Service
@Transactional(rollbackFor = {HttpServiceExceptionHandle.class, SQLException.class }, noRollbackFor = EntityNotFoundException.class)
public class TransporterService {
}
