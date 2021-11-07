# NicoProgress

[![Version](https://img.shields.io/cocoapods/v/NicoProgress.svg?style=flat)](http://cocoapods.org/pods/NicoProgress)
[![License](https://img.shields.io/cocoapods/l/NicoProgress.svg?style=flat)](http://cocoapods.org/pods/NicoProgress)
[![Platform](https://img.shields.io/cocoapods/p/NicoProgress.svg?style=flat)](http://cocoapods.org/pods/NicoProgress)
[![Carthage compatible](https://img.shields.io/badge/Carthage-compatible-4BC51D.svg?style=flat)](https://github.com/Carthage/Carthage)

iOS implementation of [material progress bars](https://material.io/guidelines/components/progress-activity.html#progress-activity-types-of-indicators).

## About

I needed a simple Material Design progress bar, with both determinate and indeterminate states, for a project I was working on. No other Pod I looked at supported both these features; and they did not respond well to resizes, or being added via Interface Builder.

![Example GIF](https://i.imgur.com/zwx4B0U.gif)

## Usage

Add NicoProgressBar to your nib or programmatically as a subview.

#### Set Progress
```
progressBar.transition(to: .determinate(percentage: 0.5))
```
#### Indeterminate
```
progressBar.transition(to: .indeterminate)
```

## Customization

#### Colors
```
progressBar.primaryColor = .blue
progressBar.secondaryColor = .white
```

#### Duration
```
progressBar.indeterminateAnimationDuration = 1.5
progressBar.determinateAnimationDuration = 1.5
```

## State
`progressBar.state`
```
case indeterminate
case determinate(percentage: CGFloat)
```

## Example

To run the example project, clone the repo, and run `pod install` from the Example directory first.

## Requirements

iOS Deployment Target >= 8.0
Swift 3.2 or 4

## Installation

NicoProgress is available through [CocoaPods](http://cocoapods.org). To install
it, simply add the following line to your Podfile:

```ruby
pod 'NicoProgress'
```

## Author

Nicolas Richard, nicorichard@gmail.com

## License

NicoProgress is available under the MIT license. See the LICENSE file for more info.
