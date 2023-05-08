package com.example.Mapping.Service;

import java.util.List;

import com.example.Mapping.Entity.Asset;


public interface AssetService {

	Asset createAsset (Asset asset);
	
	Asset updateAsset(Asset asset);
	
	List<Asset>getAllAsset();
	
	Asset getAssetById(long assetId);
	
}

