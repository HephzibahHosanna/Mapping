package com.example.Mapping.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.Entity.Asset;
import com.example.Mapping.Exception.NoRecordFoundException;
import com.example.Mapping.Repository.AssetRepository;


@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetRepository assetRepository;

	@Override
	public Asset createAsset(Asset asset) {
		return assetRepository.save(asset);
	}

	@Override
	public Asset updateAsset(Asset asset) {
		Optional<Asset> assetDb = this.assetRepository.findById(asset.getId());
		
		if(assetDb.isPresent()) {
			Asset assetUpdate = assetDb.get();
			assetUpdate.setId(asset.getId());
			assetUpdate.setName(asset.getName());
			assetRepository.save(assetUpdate);
			return assetUpdate;
		}else {
			throw new NoRecordFoundException("Record not found with id : " + asset.getId());
		}		
	}

	@Override
	public List<Asset> getAllAsset() {
		return this.assetRepository.findAll();
	}

	@Override
	public Asset getAssetById(long assetId) {
		Optional<Asset> assetDb = this.assetRepository.findById(assetId);
		
		if(assetDb.isPresent()) {
			return assetDb.get();
		}else {
			throw new NoRecordFoundException("Record not found with id : " + assetId);
		}
	}
}
