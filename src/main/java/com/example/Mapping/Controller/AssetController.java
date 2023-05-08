package com.example.Mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mapping.Entity.Asset;
import com.example.Mapping.Service.AssetService;

import jakarta.validation.Valid;

@RestController
public class AssetController {

	@Autowired
	private AssetService assetService;	
	
	
	@PostMapping("/assets")
	public ResponseEntity<Asset> createAsset(@Valid @RequestBody Asset asset){
		this.assetService.createAsset(asset);
		return ResponseEntity.ok().body(this.assetService.createAsset(asset));
	}

	@PutMapping("/assets/{id}")
	public ResponseEntity<Asset> updateAsset(@Valid @PathVariable long id, @RequestBody Asset asset){
		asset.setId(id);
		return ResponseEntity.ok().body(this.assetService.updateAsset(asset));
	}
	
	@GetMapping("/assets")
	public ResponseEntity<List<Asset>> getAllAsset(){
		return ResponseEntity.ok().body(this.assetService.getAllAsset());
	}	
	
	@GetMapping("/assets/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable long id){
		return ResponseEntity.ok().body(this.assetService.getAssetById(id));
	}
	
	
}
