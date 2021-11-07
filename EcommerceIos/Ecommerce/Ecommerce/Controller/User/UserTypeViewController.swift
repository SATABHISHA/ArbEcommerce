//
//  UserTypeViewController.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 08/10/21.
//

import UIKit

class UserTypeViewController: UIViewController {

    @IBOutlet weak var LabelBusinessType: UILabel!
    @IBOutlet weak var custom_btn_wholesaler: DesignableButton!
    @IBOutlet weak var custom_btn_retailer: DesignableButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        LabelBusinessType.text = "What is your \n Business type?"
        
        //WholeSaler onclick
        let tapGestureRecognizerWholeSalerView = UITapGestureRecognizer(target: self, action: #selector(WholeSalerView(tapGestureRecognizer:)))
        custom_btn_wholesaler.isUserInteractionEnabled = true
        custom_btn_wholesaler.addGestureRecognizer(tapGestureRecognizerWholeSalerView)
        
        //Retailer onclick
        let tapGestureRecognizerRetailerView = UITapGestureRecognizer(target: self, action: #selector(RetailerView(tapGestureRecognizer:)))
        custom_btn_retailer.isUserInteractionEnabled = true
        custom_btn_retailer.addGestureRecognizer(tapGestureRecognizerRetailerView)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    //---WholeSaler onclick
    @objc func WholeSalerView(tapGestureRecognizer: UITapGestureRecognizer){
        self.performSegue(withIdentifier: "register", sender: nil)
        //        self.performSegue(withIdentifier: "attendancerecord", sender: nil)
        
    }
    
    //---Retailer onclick
    @objc func RetailerView(tapGestureRecognizer: UITapGestureRecognizer){
        self.performSegue(withIdentifier: "register", sender: nil)
        //        self.performSegue(withIdentifier: "attendancerecord", sender: nil)
        
    }

}
