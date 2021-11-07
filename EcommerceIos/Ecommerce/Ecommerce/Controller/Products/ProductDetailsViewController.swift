//
//  ProductDetailsViewController.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 11/10/21.
//

import UIKit

class ProductDetailsViewController: UIViewController,  UICollectionViewDelegate, UICollectionViewDataSource {
    @IBOutlet weak var designablebtn_bulk_order_quote: DesignableButton!
    @IBOutlet weak var designablebtn_cart: DesignableButton!
    @IBOutlet weak var StackViewButtons: UIStackView!
    @IBOutlet weak var CollectionViewProducts: UICollectionView!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        CollectionViewProducts.delegate = self
        CollectionViewProducts.dataSource = self
        //-----code to add button border, starts------
        StackViewButtons.addBorder(side: .top, color: UIColor(hexFromString: "7F7F7F"), width: 0.6)
        designablebtn_cart.addBorder(side: .left, color: UIColor(hexFromString: "7F7F7F"), width: 0.6)
        //-----code to add button border, ends------
        
        //MyAttendanceLog OnClick
        let tapGestureRecognizerBulOrderDesignablebtn = UITapGestureRecognizer(target: self, action: #selector(DesignablebtnBulkOrder(tapGestureRecognizer:)))
        designablebtn_bulk_order_quote.isUserInteractionEnabled = true
        designablebtn_bulk_order_quote.addGestureRecognizer(tapGestureRecognizerBulOrderDesignablebtn)
        
        //SubordinateAttendance OnClick
        let tapGestureRecognizerCartbtn = UITapGestureRecognizer(target: self, action: #selector(DesignablebtnCart(tapGestureRecognizer:)))
        designablebtn_cart.isUserInteractionEnabled = true
        designablebtn_cart.addGestureRecognizer(tapGestureRecognizerCartbtn)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    //---BulkQuote OnClick
    @objc func DesignablebtnBulkOrder(tapGestureRecognizer: UITapGestureRecognizer){
        
    }
    
    //---Cart OnClick
    @objc func DesignablebtnCart(tapGestureRecognizer: UITapGestureRecognizer){
        
    }
    
    
   
    override func viewWillLayoutSubviews() {
        super.viewWillLayoutSubviews()
        CollectionViewProducts.collectionViewLayout.invalidateLayout()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        
        return 5
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cell", for: indexPath) as! ProductDetailsCollectionViewCell
        cell.layer.borderColor = UIColor.black.cgColor
        cell.layer.borderWidth = 1
//        cell.ProductNamePrice.text = dataSource[indexPath.row]
        cell.ProductImage.image = UIImage(named: "oppo")
        return cell
    }

};
extension UIView {

    public enum BorderSide {
        case top, bottom, left, right
    }

    public func addBorder(side: BorderSide, color: UIColor, width: CGFloat) {
            let border = UIView()
            border.translatesAutoresizingMaskIntoConstraints = false
            border.backgroundColor = color
            self.addSubview(border)

            let topConstraint = topAnchor.constraint(equalTo: border.topAnchor)
            let rightConstraint = trailingAnchor.constraint(equalTo: border.trailingAnchor)
            let bottomConstraint = bottomAnchor.constraint(equalTo: border.bottomAnchor)
            let leftConstraint = leadingAnchor.constraint(equalTo: border.leadingAnchor)
            let heightConstraint = border.heightAnchor.constraint(equalToConstant: width)
            let widthConstraint = border.widthAnchor.constraint(equalToConstant: width)


            switch side {
            case .top:
                NSLayoutConstraint.activate([leftConstraint, topConstraint, rightConstraint, heightConstraint])
            case .right:
                NSLayoutConstraint.activate([topConstraint, rightConstraint, bottomConstraint, widthConstraint])
            case .bottom:
                NSLayoutConstraint.activate([rightConstraint, bottomConstraint, leftConstraint, heightConstraint])
            case .left:
                NSLayoutConstraint.activate([bottomConstraint, leftConstraint, topConstraint, widthConstraint])
            }
        }
};
extension UIColor {
    convenience init(hexFromString:String, alpha:CGFloat = 1.0) {
        var cString:String = hexFromString.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()
        var rgbValue:UInt32 = 10066329 //color #999999 if string has wrong format
        
        if (cString.hasPrefix("#")) {
            cString.remove(at: cString.startIndex)
        }
        
        if ((cString.count) == 6) {
            Scanner(string: cString).scanHexInt32(&rgbValue)
        }
        
        self.init(
            red: CGFloat((rgbValue & 0xFF0000) >> 16) / 255.0,
            green: CGFloat((rgbValue & 0x00FF00) >> 8) / 255.0,
            blue: CGFloat(rgbValue & 0x0000FF) / 255.0,
            alpha: alpha
        )
    }
}
