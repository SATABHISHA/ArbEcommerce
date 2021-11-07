//
//  ProductHomeCollectionViewCell.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 08/10/21.
//

import UIKit

class ProductHomeCollectionViewCell: UICollectionViewCell {
    @IBOutlet weak var ProductImage: UIImageView!
    
    @IBOutlet weak var ProductNamePrice: UILabel!
    
    func configure(with ProductName: String){
        ProductNamePrice.text = ProductName
//        ProductImage.ima = ProductImage
    }
}
