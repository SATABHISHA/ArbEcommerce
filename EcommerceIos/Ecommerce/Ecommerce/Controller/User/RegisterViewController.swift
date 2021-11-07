//
//  RegisterViewController.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 08/10/21.
//

import UIKit

class RegisterViewController: UIViewController {

    @IBOutlet weak var custom_btn_register: DesignableButton!
    @IBOutlet weak var TxtFieldOrganizationName: UITextField!
    @IBOutlet weak var TxtFieldMobileNo: UITextField!
    @IBOutlet weak var TxtFieldEmailId: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        TxtFieldOrganizationName.setLeftPaddingPoints(12)
        TxtFieldMobileNo.setLeftPaddingPoints(12)
        TxtFieldEmailId.setLeftPaddingPoints(12)
        
        //Register onclick
        let tapGestureRecognizerRegisterView = UITapGestureRecognizer(target: self, action: #selector(RegisterView(tapGestureRecognizer:)))
        custom_btn_register.isUserInteractionEnabled = true
        custom_btn_register.addGestureRecognizer(tapGestureRecognizerRegisterView)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    //---Register onclick
    @objc func RegisterView(tapGestureRecognizer: UITapGestureRecognizer){
        self.performSegue(withIdentifier: "producthome", sender: nil)
        
    }

};
extension UITextField {
    func setLeftPaddingPoints(_ amount:CGFloat){
        let paddingView = UIView(frame: CGRect(x: 0, y: 0, width: amount, height: self.frame.size.height))
        self.leftView = paddingView
        self.leftViewMode = .always
    }
    func setRightPaddingPoints(_ amount:CGFloat) {
        let paddingView = UIView(frame: CGRect(x: 0, y: 0, width: amount, height: self.frame.size.height))
        self.rightView = paddingView
        self.rightViewMode = .always
    }
}
