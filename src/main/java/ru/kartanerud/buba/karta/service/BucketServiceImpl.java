package ru.kartanerud.buba.karta.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kartanerud.buba.karta.models.Bucket;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.repo.BucketRepo;
import ru.kartanerud.buba.karta.repo.SchebenRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService{

    private final BucketRepo bucketRepo;
    private final SchebenRepo schebenRepo;

    public BucketServiceImpl(BucketRepo bucketRepo, SchebenRepo schebenRepo) {
        this.bucketRepo = bucketRepo;
        this.schebenRepo = schebenRepo;
    }


/*    @Override
    @Transactional
    public Bucket createBucket(User user, List<Long> schebenIds) {
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Scheben> schebenList = getCollectRefSchebensByIds(schebenIds);
        bucket.setSchebens(schebenList);
        return bucketRepo.save(bucket);
    }

    private List<Scheben> getCollectRefSchebensByIds(List<Long> schebenIds){
        return schebenIds.stream()
                .map(schebenRepo::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public void addSchebens(Bucket bucket, List<Long> schebenIds) {
        List<Scheben> schebens = bucket.getSchebens();
        List<Scheben> newSchebenList = schebens == null ? new ArrayList<>() : new ArrayList<>(schebens);
        newSchebenList.addAll(getCollectRefSchebensByIds(schebenIds));
        bucket.setSchebens(newSchebenList);
        bucketRepo.save(bucket);
    }*/
}
