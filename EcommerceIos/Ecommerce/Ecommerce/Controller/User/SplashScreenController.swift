//
//  ViewController.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 05/10/21.
//

import UIKit
import NicoProgress

class SplashScreen: UIViewController {

    @IBOutlet private weak var programmaticProgressBarContainer: UIView!
    //MARK: Properties
       private var programmaticProgressBar: NicoProgressBar!
       private var state: NicoProgressBarState = .indeterminate
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        setupProgrammaticProgressBar()
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 1){ // change your delay here
              // redirect to next vc
//            self.performSegue(withIdentifier: "usertype", sender: nil)
            self.performSegue(withIdentifier: "home", sender: nil)
            }
    }
    private func setupProgrammaticProgressBar() {
            programmaticProgressBar = NicoProgressBar()
            programmaticProgressBar.primaryColor = .blue
//            programmaticProgressBar.secondaryColor = .red
            
            programmaticProgressBarContainer.addSubview(programmaticProgressBar)
            
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .top, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .top, multiplier: 1.0, constant: 0).isActive = true
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .bottom, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .bottom, multiplier: 1.0, constant: 0).isActive = true
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .leading, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .leading, multiplier: 1.0, constant: 0).isActive = true
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .trailing, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .trailing, multiplier: 1.0, constant: 0).isActive = true
        
        transition(to: .indeterminate)
        }

    //MARK: State
        internal func transition(to state: NicoProgressBarState) {
            self.state = state
            
            switch state {
                case .determinate(_):
//                    progressSlider.isHidden = false
//                    storyboardProgressBar.transition(to: state)
                    programmaticProgressBar.transition(to: state)
//                    indeterminateSwitchLabel.text = NSLocalizedString("Determinate", comment: "")
                case .indeterminate:
//                    progressSlider.isHidden = true
//                    storyboardProgressBar.transition(to: state)
                    programmaticProgressBar.transition(to: state)
//                    indeterminateSwitchLabel.text = NSLocalizedString("Indeterminate", comment: "")
            }
        }
};

extension UIViewController{
    func ChangeStatusBarColor(){
        if #available(iOS 13.0, *) {
            let app = UIApplication.shared
//            let statusBarHeight: CGFloat = app.statusBarFrame.size.height
            let window = UIApplication.shared.windows.filter {$0.isKeyWindow}.first
            let statusBarHeight: CGFloat = window?.windowScene?.statusBarManager?.statusBarFrame.height ?? 0
            
            let statusbarView = UIView()
            statusbarView.backgroundColor = UIColor(hexFromString: "323031")
            view.addSubview(statusbarView)
          
            statusbarView.translatesAutoresizingMaskIntoConstraints = false
            statusbarView.heightAnchor
                .constraint(equalToConstant: statusBarHeight).isActive = true
            statusbarView.widthAnchor
                .constraint(equalTo: view.widthAnchor, multiplier: 1.0).isActive = true
            statusbarView.topAnchor
                .constraint(equalTo: view.topAnchor).isActive = true
            statusbarView.centerXAnchor
                .constraint(equalTo: view.centerXAnchor).isActive = true
          
        } else {
            let statusBar = UIApplication.shared.value(forKeyPath: "statusBarWindow.statusBar") as? UIView
//            statusBar?.backgroundColor = UIColor(hexFromString: "2E5771")
            statusBar?.backgroundColor = UIColor(hexFromString: "323031")
        }
    }
}

