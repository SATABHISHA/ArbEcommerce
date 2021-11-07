//
//  ProductHomeViewController.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 08/10/21.
//

import UIKit

class ProductHomeViewController: UIViewController , UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout{
   
    let dataSource: [String] = ["Oppo","Vivo","Nokia"]

    @IBOutlet weak var CollectionViewProducts: UICollectionView!
    override func viewDidLoad() {
        super.viewDidLoad()

        CollectionViewProducts.delegate = self
        CollectionViewProducts.dataSource = self
        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        var columns: CGFloat
        
        let orientation = UIApplication.shared.windows.first?.windowScene?.interfaceOrientation
        if orientation == .landscapeLeft || orientation == .landscapeRight {
            columns = 6
        } else {
            columns = 2
        }
        
        let spacing: CGFloat = 5
        let totalHorizontalSpacing = (columns - 1) * spacing
        
        let itemWidth = (collectionView.bounds.width - totalHorizontalSpacing) / columns
        let itemSize = CGSize(width: itemWidth, height: itemWidth * 1.2)
        return itemSize
    }
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 5
    }
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 5
    }
    override func viewWillLayoutSubviews() {
        super.viewWillLayoutSubviews()
        CollectionViewProducts.collectionViewLayout.invalidateLayout()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        
        return dataSource.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cell", for: indexPath) as! ProductHomeCollectionViewCell
        cell.layer.borderColor = UIColor.black.cgColor
        cell.layer.borderWidth = 1
        cell.ProductNamePrice.text = dataSource[indexPath.row]
        cell.ProductImage.image = UIImage(named: "oppo")
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, didDeselectItemAt indexPath: IndexPath) {
        self.performSegue(withIdentifier: "productdetails", sender: nil)
    }

}
